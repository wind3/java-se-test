package com.example.demospringboot2.javaSeTest.concurrency.thread;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/25$ 16:31$
 */
public class InterruptThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from a InterruptThread!");
        while (true){
            if (this.interrupted()){
                System.out.println("InterruptThread interrupted ");
                Thread.interrupted();
                System.out.println("已中断 = " + this.isInterrupted());
            }
        }
    }

}
