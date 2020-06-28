package com.example.demospringboot2.javaSeTest.concurrency.executor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ScheduleServiceExecutorTest {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(4);
    }
}
