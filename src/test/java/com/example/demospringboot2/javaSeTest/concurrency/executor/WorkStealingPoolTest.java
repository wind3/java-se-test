package com.example.demospringboot2.javaSeTest.concurrency.executor;

import org.junit.Test;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.*;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/26$ 7:47$
 */
public class WorkStealingPoolTest {
    // 线程数
    private static final int threads = 10;
    // 用于计数线程是否执行完成
    CountDownLatch countDownLatch = new CountDownLatch(threads);

    /**
     * newFixedThreadPool execute
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        System.out.println("---- start ----");
        ExecutorService executorService = Executors.newScheduledThreadPool(10);
        ExecutorService executorService1 = Executors.newWorkStealingPool();
        for (int i = 0; i < threads; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("---- end ----");
    }

    /**
     * newFixedThreadPool submit submit
     */
    @Test
    public void test2() throws InterruptedException {
        System.out.println("---- start ----");
        ExecutorService executorService = Executors.newWorkStealingPool();
        for (int i = 0; i < threads; i++) {
//            Callable 带返回值
            executorService.submit(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }));
        }
        countDownLatch.await();
        System.out.println("---- end ----");
    }
    /**
     * newFixedThreadPool submit Callable
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        System.out.println("---- start ----");
        ExecutorService executorService1 = Executors.newWorkStealingPool();
        ExecutorService executorService = new ThreadPoolExecutor(10,10,5, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < threads; i++) {
//          Runnable 带返回值
            FutureTask<?> futureTask = new FutureTask<>(new Callable<String>() {
                /**
                 * call
                 * @return currentThreadName
                 */
                @Override
                public String call() {
                    return Thread.currentThread().getName();
                }
            });
            executorService.submit(new Thread(futureTask));
            System.out.println(futureTask.get());
        }
        System.out.println("---- end ----");
    }
}