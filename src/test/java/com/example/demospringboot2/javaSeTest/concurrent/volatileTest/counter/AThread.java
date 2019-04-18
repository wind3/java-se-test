package com.example.demospringboot2.javaSeTest.concurrent.volatileTest.counter;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: zengwj
 * @CreateTime: 2019-04-18$ 13:58$
 */
public class AThread extends Thread {

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
  /*      for (int i = 0; i < 100; i++){
            CommonBean.setCount();
            System.out.println("conut = "+CommonBean.getCount());
        }*/

        for (int i = 0; i < 100; i++){
            CommonBean.setVolatileCount();
            System.out.println(Thread.currentThread().getName()+ ":volatileCount = " +CommonBean.getVolatileCount());
        }

    }
}
