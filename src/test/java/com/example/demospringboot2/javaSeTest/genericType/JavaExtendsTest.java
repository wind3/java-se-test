package com.example.demospringboot2.javaSeTest.genericType;

/**
 * @Title: 实现泛型接口
 * @Description: TODO
 * @Author: zengwj
 * @CreateTime: 2019-04-01$ 17:48$
 */
public class JavaExtendsTest <T> implements JavaGenericInterfaceTest {

    private T obj;

    public JavaExtendsTest(T obj) {
        this.obj = obj;
    }

    @Override
    public T test() {
        System.out.println(obj);
        return obj;
    }
}
