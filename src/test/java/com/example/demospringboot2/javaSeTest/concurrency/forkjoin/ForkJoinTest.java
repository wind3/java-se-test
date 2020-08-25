package com.example.demospringboot2.javaSeTest.concurrency.forkjoin;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @description:
 * @projectName:java-se-test
 * @see:com.example.demospringboot2.javaSeTest.concurrency.forkjoin
 * @author:曾维嘉
 * @createTime:2020/8/25 10:56
 * @version:1.0
 */
public class ForkJoinTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] a = {1,2,3,4,5};
        int[] b = {11,12,13,14,15};
        int[] c = {111,112,113,114,115};

        List<int[]> list = Lists.newArrayList(a,b,c);

        ForkJoinPool forkJoinPool = new ForkJoinPool(8);
        SumTasks tasks = new SumTasks(list);
        ForkJoinTask<Integer> result = forkJoinPool.submit(tasks);
        System.out.println(result.get());
    }


}
