package com.example.demospringboot2.javaSeTest.concurrency.thread;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/25$ 16:31$
 */
public class SubThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from a SubThread!");

        try {
//            当前线程 subThread 休眠 1秒钟
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("I am interruped 1 ");
//            不能再抛出
//            throw e;
        }

//      线程内 休眠，run方法是 当前线程的根，必须自己捕获 中断异常，不能传递异常给其他线程
//      所以必须用try-catch块包含，不能用throws
//        Thread.sleep(1000);

        try {
//          线程内 休眠，也无法继续向上抛出
            throwException();
        } catch (InterruptedException e) {
            System.out.println("I am interruped 2");
        }
    }


    private void throwException() throws InterruptedException {

//        这也是 主线程内
        Thread.sleep(10000);

    }
}
