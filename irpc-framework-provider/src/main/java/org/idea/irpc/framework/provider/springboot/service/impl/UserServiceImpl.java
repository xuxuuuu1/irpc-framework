package org.idea.irpc.framework.provider.springboot.service.impl;

import org.idea.irpc.framework.interfaces.UserService;
import org.idea.irpc.framework.spring.starter.common.IRpcService;

@IRpcService
public class UserServiceImpl implements UserService {

    @Override
    public void test() {
        System.out.println("test");
    }
}
