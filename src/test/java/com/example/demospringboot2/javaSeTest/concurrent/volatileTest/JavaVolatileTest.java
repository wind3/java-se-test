package com.example.demospringboot2.javaSeTest.concurrent.volatileTest;

import com.example.demospringboot2.javaSeTest.concurrent.volatileTest.counter.AThread;
import com.example.demospringboot2.javaSeTest.concurrent.volatileTest.singleton.ASingleTonThread;
import com.example.demospringboot2.javaSeTest.concurrent.volatileTest.singleton.SingletonClass;
import com.example.demospringboot2.javaSeTest.concurrent.volatileTest.state.AStateThread;
import com.example.demospringboot2.javaSeTest.concurrent.volatileTest.state.WorkStateThread;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.junit.Test;

/**
 * @Title: volatile测试
 * @Description: TODO
 * @Author: zengwj
 * @CreateTime: 2019-04-18$ 13:52$
 */
public class JavaVolatileTest {

/*    @Test
    public void test(){

        for (int i = 0 ; i < 100; i++){
            AThread thread = new AThread();
            thread.start();
        }

    }


    @Test
    public void test1(){
        WorkStateThread workStateThread = new WorkStateThread();
        WorkStateThread workStateThread2 = new WorkStateThread();
        workStateThread.start();
        workStateThread2.start();
    }*/

    @Test
    public void test2(){
       /* for (int i = 0 ; i < 10 ; i++){
            ASingleTonThread thread = new ASingleTonThread();
            thread.start();
        }*/
       SingletonClass obj = new SingletonClass();
    }




}
