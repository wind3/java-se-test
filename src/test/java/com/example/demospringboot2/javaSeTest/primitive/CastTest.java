package com.example.demospringboot2.javaSeTest.primitive;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @projectName:java-se-test
 * @see:com.example.demospringboot2.javaSeTest.primitive
 * @author:曾维嘉
 * @createTime:2020/7/10 14:45
 * @version:1.0
 */
public class CastTest {

    @Test
    public void contextLoads() throws ParseException {
        String b = "20200710150703000";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        Date parse = formatter.parse(b);

        SimpleDateFormat targetFormat = new SimpleDateFormat("HH:mm:ss.SSS");

        String result = targetFormat.format(parse);

        System.out.println(result);

        long a = 100001001;
        BigDecimal decimal = new BigDecimal( a / 10000.0);

        System.out.println("de = " + (double)a /10000);
    }
}
