package com.example.demospringboot2.javaSeTest.concurrent.volatileTest.state;

/**
 * @Title: 状态通知
 * @Description: TODO
 * @Author: zengwj
 * @CreateTime: 2019-04-18$ 14:40$
 */
public class StateVolatileBean {

    public volatile static boolean closed = false;

    public static void close(){
        closed = true;
    }

    public static void open(){
        closed = false;
    }
}
