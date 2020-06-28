package com.example.demospringboot2.javaSeTest.annotationTest;

/**
 * @Title: 实现泛型接口
 * @Description: 延后泛型指定
 * @Author: lovelin
 * @CreateTime: 2019/12/3$ 21:36$
 */
public class GenericsClassImplementsInterfaceTest<T> implements GenericsInterfaceTest<T> {

    private T obj;

    public GenericsClassImplementsInterfaceTest() {
    }

    public GenericsClassImplementsInterfaceTest(T obj) {
        this.obj = obj;
    }

    @Override
    public T select() {
        return this.obj ;
    }

    @Override
    public T[] arr() {
        return null;
    }
}
