package com.example.demospringboot2.javaSeTest.concurrency.thread;

import java.util.concurrent.Callable;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/27$ 10:25$
 */
public class HelloCallable implements Callable<String> {
    // 可抛出异常，可返回结果
    @Override
    public String call() throws Exception {
        return "hello";
    }
}
