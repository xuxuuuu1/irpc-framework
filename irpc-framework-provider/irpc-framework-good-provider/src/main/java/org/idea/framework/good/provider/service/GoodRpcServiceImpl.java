package org.idea.framework.good.provider.service;

import org.idea.irpc.framework.interfaces.good.GoodRpcService;
import org.idea.irpc.framework.spring.starter.common.IRpcService;

import java.util.Arrays;
import java.util.List;

@IRpcService
public class GoodRpcServiceImpl implements GoodRpcService {

    @Override
    public boolean decreaseStock() {
        return true;
    }

    @Override
    public List<String> selectGoodsNoByUserId(String userId) {
        return Arrays.asList(userId + "-good-01", userId + "-good-02");
    }
}
