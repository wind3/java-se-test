package com.example.demospringboot2.javaSeTest.thread.pc1;

import com.example.demospringboot2.javaSeTest.thread.CarSellJob;
import com.example.demospringboot2.javaSeTest.thread.pc1.ConsumeJob;
import com.example.demospringboot2.javaSeTest.thread.pc1.ProduceJob;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Title: 多线程
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/12/5$ 20:54$
 */
public class ThreadTest {

    private ExecutorService executorService = new ThreadPoolExecutor(2,4,5, TimeUnit.MINUTES,new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardPolicy());

    @Test
    public void test(){

        CarSellJob job = new CarSellJob(new byte[0]);

        Thread thread = new Thread(job);
        thread.start();
        try {
            //线程A插入当前线程main，main等待A执行完后才能继续执行
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
//        executorService.execute(job);

        System.out.println(Thread.currentThread().getName() + "结束");
    }

    @Test
    public void test1(){

        CarSellJob job = new CarSellJob(new byte[0]);
        Thread thread = new Thread(job);
        thread.start();
        thread.interrupt();
        System.out.println(thread.getName() + thread.isInterrupted() );
        System.out.println(Thread.currentThread().getName() + Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().getName() + "结束");
    }

    @Test
    public void test2(){

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        ConsumeJob consumeJob = new ConsumeJob(queue);
        ProduceJob produceJob = new ProduceJob(queue);

        new Thread(consumeJob).start();
        new Thread(produceJob).start();

//        executorService.execute(consumeJob);
//        executorService.execute(produceJob);
//        while (true){}
    }

    public static void main(String[] args){
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        ConsumeJob consumeJob = new ConsumeJob(queue);
        ProduceJob produceJob = new ProduceJob(queue);

        new Thread(consumeJob).start();
        new Thread(produceJob).start();
    }
}
