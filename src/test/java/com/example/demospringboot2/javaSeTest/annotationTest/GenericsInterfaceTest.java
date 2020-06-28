package com.example.demospringboot2.javaSeTest.annotationTest;

/**
 * @Title: 泛型接口
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/12/3$ 21:30$
 */
public interface GenericsInterfaceTest<T> {

    T select();

    T[] arr();
}
