package com.example.demospringboot2.javaSeTest.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Title: JDK动态代理
 * @Description: Proxy+InvocationHandler
 * @Author: zengwj
 * @CreateTime: 2019-04-01$ 09:21$
 */
public class JavaProxyTest {


    @Test
    public void test(){

        RealTargetServiceImpl realTargetService = new RealTargetServiceImpl();
        InvocationHandler handler = new MyEatInvocationHandler(realTargetService);

        TargetService proxy = (TargetService) Proxy.newProxyInstance(realTargetService.getClass().getClassLoader(),realTargetService.getClass().getInterfaces(),handler);

        //每个方法都会走代理
        proxy.eat();
        //每个方法都会走代理
        proxy.sleep();
    }
}
