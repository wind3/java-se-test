package com.example.demospringboot2.javaSeTest.concurrent.volatileTest.state;

import com.example.demospringboot2.javaSeTest.concurrent.volatileTest.counter.CommonBean;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: zengwj
 * @CreateTime: 2019-04-18$ 14:44$
 */
public class WorkStateThread extends  Thread {
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

        while(!StateVolatileBean.closed){
            CommonBean.setVolatileCount();
            System.out.println(Thread.currentThread().getName() + "running" + CommonBean.getVolatileCount());
            if (100 == CommonBean.getVolatileCount()){
                StateVolatileBean.close();
            }
        }
    }
}
