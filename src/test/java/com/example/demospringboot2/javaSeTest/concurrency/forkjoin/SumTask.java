package com.example.demospringboot2.javaSeTest.concurrency.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @description:
 * @projectName:java-se-test
 * @see:com.example.demospringboot2.javaSeTest.concurrency.forkjoin
 * @author:曾维嘉
 * @createTime:2020/8/25 11:02
 * @version:1.0
 */
public class SumTask extends RecursiveTask<Integer> {

    int[] arr ;

    public SumTask(int[] arr) {
        this.arr = arr;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        int sum = 0;
        for (int i : arr){
            sum += i;
        }
        return sum;
    }
}
