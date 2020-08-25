package com.example.demospringboot2.javaSeTest.concurrency.forkjoin;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * @description:
 * @projectName:java-se-test
 * @see:com.example.demospringboot2.javaSeTest.concurrency.forkjoin
 * @author:曾维嘉
 * @createTime:2020/8/25 10:56
 * @version:1.0
 */
public class SumTasks extends RecursiveTask<Integer> {

    static final int THRESHOLD = 10;

    List<int[]> list;

    public SumTasks(List<int[]> list) {
        this.list = list;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        List<SumTask> taskList = Lists.newArrayList();
        int sum = 0;
        for (int[] arr : list){
            SumTask task = new SumTask(arr);
            taskList.add(task);
        }
        invokeAll(taskList);

        for (SumTask task : taskList){
            sum += task.join();
        }

        return sum;
    }
}
