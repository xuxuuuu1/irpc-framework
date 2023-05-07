package org.idea.irpc.framework.core.filter.client;

import org.idea.irpc.framework.core.common.ChannelFutureWrapper;
import org.idea.irpc.framework.core.common.RpcInvocation;
import org.idea.irpc.framework.core.filter.IClientFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.idea.irpc.framework.core.common.cache.CommonClientCache.CLIENT_CONFIG;

/**
 * 客户端调用日志过滤器
 */
public class ClientLogFilterImpl implements IClientFilter {

    private static Logger logger = LoggerFactory.getLogger(ClientLogFilterImpl.class);

    @Override
    public void doFilter(List<ChannelFutureWrapper> src, RpcInvocation rpcInvocation) {
        rpcInvocation.getAttachments().put("c_app_name",CLIENT_CONFIG.getApplicationName());
        logger.debug(rpcInvocation.getAttachments().get("c_app_name")+" do invoke -----> "+rpcInvocation.getTargetServiceName());
    }

}
