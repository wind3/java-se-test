package com.example.demospringboot2.javaSeTest.thread.pc2;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @Title: 生产者
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/12/5$ 21:03$
 */
public class ProduceJob implements Runnable {

    private LinkedList<Integer> queue;
    private int count = 0;
    private int MAX = 20;

    public ProduceJob(LinkedList<Integer> queue, Object obj03, Object obj35) {
        this.queue = queue;
        this.obj03 = obj03;
        this.obj35 = obj35;
    }

    private Object obj03;
    private Object obj35;

    public ProduceJob(LinkedList<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());

        while (true){
            if (queue != null){
                synchronized (queue){
                    if (MAX < queue.size()){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count < 100){
                        queue.add(count++);
                        queue.notifyAll();
                    }else {
                        break;
                    }

                }
            }


        }
    }

}
