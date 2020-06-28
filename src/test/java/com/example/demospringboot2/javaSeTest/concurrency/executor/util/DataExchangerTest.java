package com.example.demospringboot2.javaSeTest.concurrency.executor.util;

import java.util.concurrent.Exchanger;

public class DataExchangerTest {

    public static void main(String[] args) {
        // 线程数据交换机
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread( () -> {
            try {
                System.out.println("A:" +"我原本有一个苹果");
                String str = exchanger.exchange("我现在有一个苹果");
                Thread.sleep(1000);
                System.out.println("A:" + str);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread( () -> {
            try {
                System.out.println("B:" +"我原本有一个梨");
                String str = exchanger.exchange("我现在有一个梨");
                Thread.sleep(1000);
                System.out.println("B:" + str);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
