//package org.idea.irpc.framework.core.proxy.javassist.demo;
//
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.util.List;
//
//public class Demo$Proxy {
//
//    public static Method[] methods;
//
//    private InvocationHandler invocationHandler;
//
//    public Demo$Proxy(InvocationHandler invocationHandlers) {
//        this.invocationHandler = invocationHandlers;
//    }
//
////    @Override
//    public String sendData(String body) {
//        Object[] objectArray = new Object[]{};
//        Object object = this.invocationHandler.invoke(this, methods[1], objectArray);
//        return (String) object;
//    }
//
////    @Override
//    public List<String> getList() {
//        Object[] objectArray = new Object[]{};
//        Object object = this.invocationHandler.invoke(this, methods[1], objectArray);
//        return (List<String>) object;
//    }
//
//
//}
