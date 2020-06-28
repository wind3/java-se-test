package com.example.demospringboot2.javaSeTest.concurrency.thread.lockAndCondition;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/27$ 19:33$
 */
public class LockAndConditionTest {

    public static void main(String[] args) {
        // 可重入锁
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread A = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("我获得锁了");
                System.out.println("可以做事情了");
            } finally {
                lock.unlock();
            }
            System.out.println("我释放锁了");
        }, "A");

        Thread B = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("我也获得锁了");
                System.out.println("我也可以做事情了");
            } finally {
                lock.unlock();
            }
            System.out.println("我也释放锁了");
        }, "B");

        A.start();
        B.start();
    }

    public static void one(){
        // 可重入锁
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread A = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("我获得锁了");
                System.out.println("可以做事情了");
            } finally {
                lock.unlock();
            }
            System.out.println("我释放锁了");
        }, "A");

        Thread B = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("我也获得锁了");
                System.out.println("我也可以做事情了");
            } finally {
                lock.unlock();
            }
            System.out.println("我也释放锁了");
        }, "B");

        A.start();
        B.start();
    }

    public static void two(){

        Queue<String> store = new LinkedList<>();
        // 可重入锁
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread p = new Thread(() -> {
            for (; ; ){
                lock.lock();

                if (store.size() < 10){
                    System.out.println("仓库还有位置，我加一个");
                    store.offer(UUID.randomUUID().toString());
                }else {
                    System.out.println("仓库满了");
                }

                try {
                    Thread.sleep(1000);
                    // 休眠，等待被唤醒
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (store.size() > 0){
                    System.out.println("仓库还有货，请来食用");
                }
                // 唤醒锁
                condition.signal();
            }

        });

        Thread c = new Thread(() -> {
            for (; ; ){
                lock.lock();

                if (store.size() > 0){
                    String poll = store.poll();
                    System.out.println("我吃了一个 = " + poll);
                }
                if (store.size() ==  0){
                    System.out.println("仓库没货了，请生产");
                }
                // 唤醒锁
                condition.signal();
                try {
                    Thread.sleep(1000);
                    // 休眠，等待被唤醒
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        p.start();
        c.start();

        try {
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费结束");
    }
}
