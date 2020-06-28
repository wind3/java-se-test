package com.example.demospringboot2.javaSeTest.thread.pc1;

import java.util.concurrent.BlockingQueue;

/**
 * @Title: 消费者
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/12/5$ 21:03$
 */
public class ConsumeJob implements Runnable {

    private BlockingQueue<String> obj;

    public ConsumeJob(BlockingQueue<String> obj) {
        this.obj = obj;
    }


    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());

        while (true){
            if (obj != null && isFull(obj)){
                synchronized (obj){
                    while (!obj.isEmpty()){
                        try {
                            Thread.sleep(1000);
                            String take = obj.take();
                            System.out.println(Thread.currentThread().getName() + "消费" + take);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private boolean isFull(BlockingQueue<String> obj){
        return obj.remainingCapacity() == 0;
    }
}
