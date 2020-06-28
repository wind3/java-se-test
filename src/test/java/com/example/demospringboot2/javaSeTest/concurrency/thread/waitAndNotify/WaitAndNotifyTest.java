package com.example.demospringboot2.javaSeTest.concurrency.thread.waitAndNotify;

import org.junit.Test;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/27$ 18:42$
 */
public class WaitAndNotifyTest {

    @Test
    public void test() {


    }

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (obj) {
                    if (i == 0){
                        System.out.println("我要卖，谁要买？");
                    }
                    try {
                        Thread.sleep(100);
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if ( i < 9){
                        System.out.println("新货到了，谁要买？");
                    }
                    obj.notify();
                }
            }
            System.out.println("卖完了");
        });


        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (obj) {
                    System.out.println("我买了");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    obj.notify();

                    try {
                        System.out.println("还有的话，麻烦通知我。");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("再见");
        });

        t1.start();
        t2.start();

        t2.join();

        System.out.println("交易结束");
    }
}
