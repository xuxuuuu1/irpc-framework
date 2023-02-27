package org.idea.irpc.framework.core.router.ConsistentHash;

import org.idea.irpc.framework.core.common.ChannelFutureWrapper;
import org.idea.irpc.framework.core.common.utils.CommonUtils;
import org.idea.irpc.framework.core.common.utils.HashImpl.JDKHashStrategy;
import org.idea.irpc.framework.core.common.utils.HashStrategy;
import org.idea.irpc.framework.core.registy.URL;
import org.idea.irpc.framework.core.router.IRouter;
import org.idea.irpc.framework.core.router.Selector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.TreeMap;

import static org.idea.irpc.framework.core.common.cache.CommonClientCache.IROUTER;


public class ConsistentHashRouterImpl implements IRouter {

    private final static Logger LOGGER = LoggerFactory.getLogger(ConsistentHashRouterImpl.class);
    private HashStrategy jdkHashStrategy = new JDKHashStrategy();

    private final static Integer VIRTUAL_NODE_SIZE = 10;
    private final static String VIRTUAL_NODE_SUFFIX = "&&";

    @Override
    public void refreshRouterArr(Selector selector) {

    }

    @Override
    public ChannelFutureWrapper select(Selector selector) {
        String ipAddress = CommonUtils.getIpAddress();
        int requestHashCode = jdkHashStrategy.getHashCode(ipAddress);
        ChannelFutureWrapper[] channelFutureWrappers = selector.getChannelFutureWrappers();
        TreeMap<Integer, HashNode> ring = buildConsistentHashRing(channelFutureWrappers);
        HashNode aimNode = locate(ring, requestHashCode);
        ChannelFutureWrapper aimChannelFutureWrapper = findAimChannelFutureWrapper(channelFutureWrappers, aimNode);
        return aimChannelFutureWrapper;
    }

    @Override
    public void updateWeight(URL url) {

    }

    private TreeMap<Integer, HashNode> buildConsistentHashRing(ChannelFutureWrapper[] channelFutureWrappers) {
        TreeMap<Integer, HashNode> virtualNodeRing = new TreeMap<>();
        for (ChannelFutureWrapper channelFutureWrapper : channelFutureWrappers) {
            String ip = channelFutureWrapper.getHost();
            Integer port = channelFutureWrapper.getPort();
            HashNode server = new HashNode(ip, port);
            for (int i = 0; i < VIRTUAL_NODE_SIZE; i++) {
                virtualNodeRing.put(
                        jdkHashStrategy.getHashCode(server.getIpAndPort() + VIRTUAL_NODE_SUFFIX + i), server);
            }
        }

        return virtualNodeRing;
    }

    private HashNode locate(TreeMap<Integer, HashNode> ring, int requestHashCode) {
        // 向右找到第一个key
        Map.Entry<Integer, HashNode> locateEntry = ring.ceilingEntry(requestHashCode);
        if (locateEntry == null) {
            locateEntry = ring.firstEntry();
        }
        return locateEntry.getValue();
    }

    private ChannelFutureWrapper findAimChannelFutureWrapper(ChannelFutureWrapper[] channelFutureWrappers, HashNode hashNode) {
        if (channelFutureWrappers.length == 0) {
            throw new RuntimeException("no server exist!");
        }
        for (ChannelFutureWrapper channelFutureWrapper : channelFutureWrappers) {
            String source = channelFutureWrapper.getHost() + ":" + channelFutureWrapper.getPort();
            if (source.equals(hashNode.getIpAndPort())) {
                return channelFutureWrapper;
            }
        }
        throw new RuntimeException("Consistency hashing fails!");
    }


}
