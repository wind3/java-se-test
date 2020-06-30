package com.example.demospringboot2.javaSeTest.concurrency.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @projectName:java-se-test
 * @see:com.example.demospringboot2.javaSeTest.concurrency.collection
 * @author:曾维嘉
 * @createTime:2020/6/30 8:05
 * @version:1.0
 */
public class ConcurrentMapTest {

    public static void main(String[] args) {

        Map<String,String> map = new ConcurrentHashMap<>();
    }
}
