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

    private static final String SOH = String.valueOf('\001');
    private static final String BODY_LENGTH_FIELD = SOH + String.valueOf(9) + '=';
    private static final String CHECKSUM_FIELD = SOH + String.valueOf(10) + '=';

    public static void main(String[] args) {

        Map<String,String> map = new ConcurrentHashMap<>();
        StringBuilder stringBuilder = new StringBuilder("8=FIXT.1.1\u00019=112\u000135=A\u000134=1\u000149=WKZQ\u000152=20200703-10:05:41.132\u000156=GSX\u000198=0\u0001108=30\u0001141=Y\u0001789=1\u00011137=9\u00011407=124\u00011408=STEP1.20_SZ_1.02\u000110=002\u0001");
        setBodyLength(stringBuilder);
        System.out.println( tableSizeFor( 3 + (3 >>> 1) + 1));
    }

    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1111111111) ? 1111111111 : n + 1;
    }

    private static void setBodyLength(StringBuilder stringBuilder) {
        int bodyLengthIndex = stringBuilder.indexOf(BODY_LENGTH_FIELD, 0);
        int sohIndex = stringBuilder.indexOf(SOH, bodyLengthIndex + 1);
        int checkSumIndex = stringBuilder.lastIndexOf(CHECKSUM_FIELD);
        int length = checkSumIndex - sohIndex;
        bodyLengthIndex += BODY_LENGTH_FIELD.length();
        StringBuilder replace = stringBuilder.replace(bodyLengthIndex, bodyLengthIndex + 3, String.valueOf(length));
        System.out.println(replace);
    }

}
