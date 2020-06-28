package com.example.demospringboot2.javaSeTest.concurrency.executor.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/27$ 23:46$
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println( "孩子们已经准备好，可以开始");
        });

        new Thread( () -> {
            System.out.println("小明说：我要先穿衣服");
            try {
                Thread.sleep(1000);
                System.out.println("小明说：准备好了");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        },"小明").start();

        new Thread( () -> {
            System.out.println("小东说：我要先刷牙");
            try {
                Thread.sleep(3000);
                System.out.println("小东说：准备好了");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        },"小东").start();

        new Thread( () -> {
            System.out.println("小小说：我要先吃饭");
            try {
                Thread.sleep(5000);
                System.out.println("小小说：准备好了");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        },"小小").start();

    }
}
