package com.example.demospringboot2.javaSeTest.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

        Map<String,String> map = new HashMap(3);

        for (int i = 0; i < 4; i++) {

            map.put("key" + i,"valu" + i);
        }

        map.remove("key2");
        map.getOrDefault("wind","default wind3");
    }

    @Test
    public void test(){
        int i = 128 - (128 >>> 2);
        System.out.println(i);
    }
}
