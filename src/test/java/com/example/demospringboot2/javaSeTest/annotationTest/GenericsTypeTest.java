package com.example.demospringboot2.javaSeTest.annotationTest;

/**
 * @Title: 泛型方法
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/12/3$ 21:44$
 */
public class GenericsTypeTest {

    <T> void exec(T t){
        System.out.println(t);
    }


}
