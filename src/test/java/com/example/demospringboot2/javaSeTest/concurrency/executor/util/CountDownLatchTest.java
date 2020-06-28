package com.example.demospringboot2.javaSeTest.concurrency.executor.util;

import java.util.concurrent.CountDownLatch;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/27$ 22:42$
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final int N = 5;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();

        System.out.println("子线程还未开始");
        startSignal.countDown();      // let all threads proceed
        System.out.println("子线程可以开始了");

        try {
            System.out.println("我睡一会");
            Thread.sleep(1000);
            doneSignal.await();           // wait for all to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("子线程执行结束，我的任务完成");
    }

    public static void  test1(){
        final int count = 5;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            System.out.println("释放第" + i + "次");
            countDownLatch.countDown();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行结束");
    }
}

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }
    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException ex) {} // return;
    }

    void doWork() {
        System.out.println("子线程开始在工作");
    }
}

