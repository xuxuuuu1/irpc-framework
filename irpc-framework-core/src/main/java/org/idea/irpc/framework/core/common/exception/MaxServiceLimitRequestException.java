package org.idea.irpc.framework.core.common.exception;

import org.idea.irpc.framework.core.common.RpcInvocation;

public class MaxServiceLimitRequestException extends IRpcException{

    public MaxServiceLimitRequestException(RpcInvocation rpcInvocation) {
        super(rpcInvocation);
    }
}
