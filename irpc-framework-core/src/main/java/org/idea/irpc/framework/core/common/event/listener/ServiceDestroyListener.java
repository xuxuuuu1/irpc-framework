package org.idea.irpc.framework.core.common.event.listener;

import org.idea.irpc.framework.core.common.event.IRpcDestroyEvent;
import org.idea.irpc.framework.core.registy.URL;

import static org.idea.irpc.framework.core.common.cache.CommonServerCache.PROVIDER_URL_SET;
import static org.idea.irpc.framework.core.common.cache.CommonServerCache.REGISTRY_SERVICE;

/**
 * 服务注销 监听器
 */
public class ServiceDestroyListener implements IRpcListener<IRpcDestroyEvent> {

    @Override
    public void callBack(Object t) {
        for (URL url : PROVIDER_URL_SET) {
            REGISTRY_SERVICE.unRegister(url);
        }
    }
}
