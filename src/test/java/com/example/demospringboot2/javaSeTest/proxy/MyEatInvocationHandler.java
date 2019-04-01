package com.example.demospringboot2.javaSeTest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: zengwj
 * @CreateTime: 2019-04-01$ 09:38$
 */
public class MyEatInvocationHandler implements  InvocationHandler {

    private Object target ;

    public MyEatInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before I eat");

        method.invoke(target,args);

        System.out.println("after I eat");
        return null;
    }
}
