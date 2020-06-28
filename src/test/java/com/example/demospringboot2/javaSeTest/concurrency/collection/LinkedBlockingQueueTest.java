package com.example.demospringboot2.javaSeTest.concurrency.collection;

import net.bytebuddy.utility.RandomString;

import java.util.concurrent.*;

public class LinkedBlockingQueueTest {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(10);
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer(blockingQueue);
            executorService.execute(producer);
        }
        Consumer consumer = new Consumer(blockingQueue);
        executorService.execute(consumer);

    }

    static class Producer implements Runnable{

        private BlockingQueue<String> blockingQueue;

        private final static int N = 10;

        public Producer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < N; i++) {
                try {
                    String str = new RandomString().nextString();
                    blockingQueue.put(str);
                    System.out.println(Thread.currentThread().getName() + ": 我生产了 = " + str);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable{

        private BlockingQueue<String> blockingQueue;

        public Consumer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    String take = blockingQueue.poll(10, TimeUnit.SECONDS);
                    if (null != take){
                        System.out.println(take + "被吃了" );
                    }else {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("美食都被我吃光了");
        }
    }
}
