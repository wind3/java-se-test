package com.example.demospringboot2.javaSeTest.concurrency.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    public static void main(String[] args) {

        AtomicInteger count = new AtomicInteger();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread( () -> {
                count.incrementAndGet();
                System.out.println(Thread.currentThread().getName() +  ": 当前值 = " + finalI);
            }, "name" +i).start();
        }
    }
}
