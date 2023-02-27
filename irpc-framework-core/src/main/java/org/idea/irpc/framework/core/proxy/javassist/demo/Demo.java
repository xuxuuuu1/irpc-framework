package org.idea.irpc.framework.core.proxy.javassist.demo;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public void doTest(){
        System.out.println("this is demo");
    }

    public String findStr(){
        return "success";
    }

    public List<String> findList(){
        return new ArrayList<>();
    }
}
