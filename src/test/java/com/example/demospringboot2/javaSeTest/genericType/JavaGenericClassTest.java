package com.example.demospringboot2.javaSeTest.genericType;

/**
 * @Title: 泛型类
 * @Description: TODO
 * @Author: zengwj
 * @CreateTime: 2019-04-01$ 17:46$
 */
public class JavaGenericClassTest <T>{
    private T obj;

    /**
     * 1、不能用new T();实例化
     * 2、不能有new T[]实例化数组
     * 3、静态环境下不能使用泛型
     * 4、异常类不能使用泛型
     * 5、简单类不能使用泛型
     * 6、不能通过泛型来重载（编译期被类型消除了）
     * 7、泛型不能调用属性或方法
     * @param obj
     */
    public JavaGenericClassTest(T obj) {
        this.obj = obj;
    }

    T aTest(){
        return obj;
    }
}
