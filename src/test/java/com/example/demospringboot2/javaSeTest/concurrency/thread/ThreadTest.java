package com.example.demospringboot2.javaSeTest.concurrency.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.FutureTask;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/25$ 16:27$
 */
@Slf4j
public class ThreadTest {

    @Test
    public void test(){

        Thread thread = new Thread(new HelloRunnable());

        thread.start();

        System.out.println(" end = " +  Thread.currentThread().getName());
    }

    @Test
    public void subTest(){

        Thread thread = new SubThread();

        thread.start();

        System.out.println(" end = " +  Thread.currentThread().getName());
    }

    @Test
    public void sleep(){

        Thread thread = new SubThread();

        thread.start();

        try {
//            当前线程 main 休眠 1秒钟
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//      非 run()方法，可以向上抛出 中断异常，可以使用 throws
//        Thread.sleep(1000);

//        throwException();

//      主线程 中断 子线程，子线程自己处理 中断异常
        thread.interrupt();

    }

    private void throwException() throws InterruptedException {

//        这也是 主线程内
        Thread.sleep(1000);

    }


    public static void main(String[] args) throws InterruptedException {
//      main 方法 可以抛出 中断异常
        Thread.sleep(1000);

        Thread subThread = new SubThread();

        subThread.start();

//       中断 subThread线程，通过给 subThread线程设置 中断标记
//       subThread 如果是运行中，不会被中断，而是继续运行
//       除非 subThread线程 已经不是runnable状态
        subThread.interrupt();

//      判断 subThread的 是否已中断
//      不会重置 subThread线程的中断标记
        subThread.isInterrupted();

//      判断当前线程是否被中断，会重置 当前线程的 中断标记
//      用于子线程内、循环内，判断当前线程是否其他线程中断了
//      可以实现运行中，自响应其他线程发出的中断信号
        Thread.interrupted();

    }

    @Test
    public void interrupt(){
//        子线程 无限循环，接收并处理 父线程 的中断请求

        Thread interruptThread = new InterruptThread();
        interruptThread.start();
        System.out.println(" 中断前 ");
//        发出中断 interruptThread 子线程的 信号
        interruptThread.interrupt();

        System.out.println(" interruptThread 是否被中断 =  " + interruptThread.isInterrupted());

    }


    @Test
    public void joinTest() throws InterruptedException {

        Thread helloThread = new Thread(new HelloRunnable());
        helloThread.start();

        helloThread.join();

        System.out.println("helloThread has finished! ");
    }

    @Test
    public void callableTest() throws InterruptedException {

        Thread helloThread = new Thread(new FutureTask<>(new HelloCallable()));
        helloThread.start();

        helloThread.join();

        System.out.println("helloThread has finished! ");
    }
}
