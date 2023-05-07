package org.idea.irpc.framework.common.consumer.controller;

import org.idea.irpc.framework.interfaces.OrderService;
import org.idea.irpc.framework.interfaces.good.GoodRpcService;
import org.idea.irpc.framework.interfaces.pay.PayRpcService;
import org.idea.irpc.framework.interfaces.user.UserRpcService;
import org.idea.irpc.framework.spring.starter.common.IRpcReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api-test")
public class ApiTestController {

    @IRpcReference
    private UserRpcService userRpcService;
    @IRpcReference
    private GoodRpcService goodRpcService;
    @IRpcReference
    private PayRpcService payRpcService;


    @GetMapping(value = "/do-test")
    public boolean doTest() {
        long begin1 = System.currentTimeMillis();
        userRpcService.getUserId();
        long end1 = System.currentTimeMillis();
        System.out.println("userRpc--->" + (end1 - begin1) + "ms");
        long begin2 = System.currentTimeMillis();
        goodRpcService.decreaseStock();
        long end2 = System.currentTimeMillis();
        System.out.println("goodRpc--->" + (end2 - begin2) + "ms");
        long begin3 = System.currentTimeMillis();
        payRpcService.doPay();
        long end3 = System.currentTimeMillis();
        System.out.println("payRpc--->" + (end3 - begin3) + "ms");
        return true;
    }


    @GetMapping(value = "/do-test-2")
    public void doTest2() {
        String userId = userRpcService.getUserId();
        System.out.println("userRpcService result: " + userId);
        boolean goodResult = goodRpcService.decreaseStock();
        System.out.println("goodRpcService result: " + goodResult);
    }
}
