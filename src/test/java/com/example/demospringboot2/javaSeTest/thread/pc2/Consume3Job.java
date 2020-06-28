package com.example.demospringboot2.javaSeTest.thread.pc2;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

/**
 * @Title: 消费者
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/12/5$ 21:03$
 */
public class Consume3Job implements Runnable {

    private LinkedList<Integer> queue;

    public Consume3Job(LinkedList<Integer> queue, Object obj03, Object obj35) {
        this.queue = queue;
        this.obj03 = obj03;
        this.obj35 = obj35;
    }

    private Object obj03;
    private Object obj35;

    public Consume3Job(LinkedList<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());

        File f = new File("");

        while (true){
            if (queue != null){
                synchronized (queue){
                    if (isMatch(queue.peek())){
                        System.out.println(Thread.currentThread().getName() + "=" + queue.poll());
                        queue.notifyAll();
                    }
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }}
    }


    private boolean isMatch(int num){
        return num % 3 == 0 ;
    }
}
