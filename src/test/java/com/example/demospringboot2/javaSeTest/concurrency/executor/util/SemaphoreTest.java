package com.example.demospringboot2.javaSeTest.concurrency.executor.util;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        // 信号量
        Semaphore semaphore = new Semaphore(1);

        new Thread( () -> {
            try {
                semaphore.acquire();
                System.out.println("我抢到票了，可以回家了");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            semaphore.release();
        }).start();

        new Thread( () -> {
            try {
                System.out.println("我还在抢票。");
                semaphore.acquire();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我也抢到票了，好开心");
            semaphore.release();
        }).start();
    }
}
