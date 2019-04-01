package com.example.demospringboot2.javaSeTest.proxy;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: zengwj
 * @CreateTime: 2019-04-01$ 09:37$
 */
public class RealTargetServiceImpl implements TargetService {
    @Override
    public void eat() {
        System.out.println("I eat");
    }

    @Override
    public void sleep() {
        System.out.println("I sleep");
    }
}
