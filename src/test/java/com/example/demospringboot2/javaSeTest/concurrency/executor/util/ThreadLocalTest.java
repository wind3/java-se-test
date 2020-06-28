package com.example.demospringboot2.javaSeTest.concurrency.executor.util;

import java.util.Random;

public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(10);

        for (int i = 0; i < 5; i++) {
            new Thread( () -> {
                System.out.println("初始值 = " + threadLocal.get());
                threadLocal.set(new Random().nextInt());
                System.out.println(threadLocal.get());
            }).start();
        }
        System.out.println(threadLocal.get());

    }
}
