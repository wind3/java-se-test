package com.example.demospringboot2.javaSeTest.concurrent.volatileTest.singleton;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: zengwj
 * @CreateTime: 2019-04-18$ 15:01$
 */
public class SingletonClass {

    //防止指令重排序
    private volatile static Object instance = null;

    public static Object getInstance(){
        if (instance == null){
            synchronized (SingletonClass.class){
                if (instance == null){
                    //可能出现指令重排序，先分配了内存地址，后实例化，导致未实例化的对象被其他线程使用
                    instance = new Object();
                }
            }
        }

        return  instance;
    }
}
