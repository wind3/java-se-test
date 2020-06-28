package com.example.demospringboot2.javaSeTest.thread.pc2;

import com.example.demospringboot2.javaSeTest.thread.CarSellJob;
import org.junit.Test;

import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * @Title: 多线程
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/12/5$ 20:54$
 */
public class ThreadTest {

    private static ExecutorService executorService = new ThreadPoolExecutor(4,8,5, TimeUnit.MINUTES,new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardPolicy());

    @Test
    public void test(){


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


    }

    public static void main(String[] args){
        LinkedList<Integer> queue = new LinkedList<>();
        ProduceJob produceJob = new ProduceJob(queue);

        byte[] obj = new byte[0];
        ConsumeJob consumeJob = new ConsumeJob(queue,queue,"");
        Consume3Job consume3Job = new Consume3Job(queue,queue,"");
        Consume5Job consume5Job = new Consume5Job(queue,queue,"");

        executorService.execute(produceJob);
        executorService.execute(consumeJob);
        executorService.execute(consume3Job);
        executorService.execute(consume5Job);

        System.out.println(Thread.currentThread().getName() + "结束");

    }
}
