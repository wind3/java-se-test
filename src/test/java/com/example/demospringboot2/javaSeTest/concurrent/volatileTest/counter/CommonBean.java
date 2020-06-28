package com.example.demospringboot2.javaSeTest.concurrent.volatileTest.counter;

/**
 * @Title: 公共对象
 * @Description: TODO
 * @Author: zengwj
 * @CreateTime: 2019-04-18$ 13:53$
 */
public class CommonBean {

    public static int count = 0;

    public static volatile int volatileCount = 0;

    public static int getCount(){
        return count;
    }

    public static int getVolatileCount(){
        return volatileCount;
    }

    public synchronized static void setCount(){
        count++;
    }

    public  synchronized static void setVolatileCount(){
        volatileCount++;
    }
}
