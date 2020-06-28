package com.example.demospringboot2.javaSeTest.thread;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/12/5$ 21:03$
 */
public class CarSellJob implements Runnable {

    private Object obj;

    public CarSellJob(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());

        if (obj != null){
            synchronized (obj){
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "结束");
                    System.out.println(Thread.currentThread().getName() + "出让开始");
                    Thread.yield();
                    System.out.println(Thread.currentThread().getName() + "出让结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName() + "被中断");
                }
            }
        }
    }
}
