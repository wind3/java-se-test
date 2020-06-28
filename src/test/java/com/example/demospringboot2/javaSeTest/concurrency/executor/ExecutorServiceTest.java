package com.example.demospringboot2.javaSeTest.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/25$ 22:45$
 */
public class ExecutorServiceTest {

    public void test(){
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
    }
}
