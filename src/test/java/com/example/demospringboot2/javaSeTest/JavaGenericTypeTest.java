package com.example.demospringboot2.javaSeTest;

import org.junit.Test;

import java.util.List;

/**
 * @Title: 泛型
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/3/31$ 10:41$
 */
public class JavaGenericTypeTest {

    @Test
    public void test( ){
       String e = this.<String>param("123");
    }


    public  <E> E param(E param){
        System.out.print(param);
        return  param;
    }


}
