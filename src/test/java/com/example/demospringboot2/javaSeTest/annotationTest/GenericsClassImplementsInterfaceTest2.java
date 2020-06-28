package com.example.demospringboot2.javaSeTest.annotationTest;

/**
 * @Title: 实现泛型接口
 * @Description: 实现接口时指定类型
 * @Author: lovelin
 * @CreateTime: 2019/12/3$ 21:36$
 */
public class GenericsClassImplementsInterfaceTest2 implements GenericsInterfaceTest<String> {

    private String obj;

    public GenericsClassImplementsInterfaceTest2() {
    }

    public GenericsClassImplementsInterfaceTest2(String obj) {
        this.obj = obj;
    }

    @Override
    public String select() {
        return this.obj ;
    }

    @Override
    public String[] arr() {
        return new String[0];
    }
}
