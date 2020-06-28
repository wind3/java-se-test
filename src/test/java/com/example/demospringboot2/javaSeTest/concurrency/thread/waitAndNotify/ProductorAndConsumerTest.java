package com.example.demospringboot2.javaSeTest.concurrency.thread.waitAndNotify;

import java.util.*;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/27$ 19:10$
 */
public class ProductorAndConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        Queue<String> store = new LinkedList<>();

        Thread p = new Thread(() -> {
            for (; ; ){

                synchronized (store){
                    if (store.size() < 10){
                        System.out.println("仓库还有位置，我加一个");
                        store.offer(UUID.randomUUID().toString());
                    }else {
                        System.out.println("仓库满了");
                    }
                    try {
                        Thread.sleep(1000);
                        store.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (store.size() > 0){
                        System.out.println("仓库还有货，请来食用");
                    }
                    store.notify();
                }
            }
        });

        Thread c = new Thread(() -> {
            for (; ; ){
                synchronized (store){
                    if (store.size() > 0){
                        String poll = store.poll();
                        System.out.println("我吃了一个 = " + poll);
                    }
                    if (store.size() ==  0){
                        System.out.println("仓库没货了，请生产");
                    }
                    store.notify();
                    try {
                        Thread.sleep(1000);
                        store.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        p.start();
        c.start();

        c.join();
        System.out.println("消费结束");
    }
}
