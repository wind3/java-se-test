package com.example.demospringboot2.javaSeTest.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * @description: 日期时间
 * @projectName:java-se-test
 * @see:com.example.demospringboot2.javaSeTest.datetime
 * @author:曾维嘉
 * @createTime:2020/7/13 8:13
 * @version:1.0
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {

        // 默认 是使用当前系统时钟的时区
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        // 指定日期时间
        LocalDateTime spDateTime = LocalDateTime.of(2019, 7, 10, 10, 10, 10);
        System.out.println(spDateTime);

        // 时间间隔
        Duration duration = Duration.between(spDateTime, dateTime);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());

        // 日期的间隔    Period 表示年月日的时间量（只计算当前单位的差，不累计向上单位的差距）
        Period period = Period.between(spDateTime.toLocalDate(), dateTime.toLocalDate());
        long perdDay = period.getDays();        // 只计算当前差，不累计年月差带来的天数差
        long perdMonth = period.getMonths();    // 只计算当前差，不累计年数差带来的月数差
        long perdYear = period.getYears();
        System.out.println(perdDay);
        System.out.println(perdMonth);
        System.out.println(perdYear);

    }
}
