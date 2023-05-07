package org.idea.irpc.framework.core.server;

import org.idea.irpc.framework.interfaces.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void test() {
        System.out.println("test");
    }
}
