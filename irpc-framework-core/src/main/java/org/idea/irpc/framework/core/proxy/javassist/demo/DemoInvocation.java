package org.idea.irpc.framework.core.proxy.javassist.demo;

import org.idea.irpc.framework.interfaces.DataService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DemoInvocation implements InvocationHandler {



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("this is invoke");
        return new Object();
    }

    public static void main(String[] args) throws Throwable {
        Method[] methods = DataService.class.getDeclaredMethods();
//        Demo$Proxy demo$Proxy = new Demo$Proxy(new DemoInvocation());
    }
}
