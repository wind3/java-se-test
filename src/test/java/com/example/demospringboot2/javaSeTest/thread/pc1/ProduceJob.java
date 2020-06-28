package com.example.demospringboot2.javaSeTest.thread.pc1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @Title: 生产者
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/12/5$ 21:03$
 */
public class ProduceJob implements Runnable {

    private BlockingQueue<String> obj;

    public ProduceJob(BlockingQueue<String> obj) {
        this.obj = obj;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());

        while (true){
            if (obj != null && obj.isEmpty()){
                synchronized (obj){
                    while (!isFull(obj)) {
                        try {
                            Thread.sleep(1000);
                            int pa = new Random().nextInt(100);
                            obj.add("thing" + pa);
                            System.out.println(Thread.currentThread().getName() + "生成" + "thing" + pa);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println(Thread.currentThread().getName() + "被中断");
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
