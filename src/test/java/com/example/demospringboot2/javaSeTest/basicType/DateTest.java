package com.example.demospringboot2.javaSeTest.basicType;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @description:
 * @projectName:java-se-test
 * @see:com.example.demospringboot2.javaSeTest.basicType
 * @author:曾维嘉
 * @createTime:2020/7/1 8:40
 * @version:1.0
 */
public class DateTest {

    public static void main(String[] args) {
        Date date = new Date();
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }
}
