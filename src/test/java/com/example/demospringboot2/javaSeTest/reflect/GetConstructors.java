package com.example.demospringboot2.javaSeTest.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 从反射类型信息中，获取构造函数，并实例化对象
 * 1、获取所有 public 构造函数
 * 2、
 * 2、实例化对象
 */
public class GetConstructors {

    @Test
    public void getConstructor() throws NoSuchMethodException {

        Class<Book> bookClass = Book.class;

        // 获取所有 public的 构造函数
        Constructor<?>[] constructors = bookClass.getConstructors();

        // 获取 所有声明的构造函数
        Constructor<?>[] declaredConstructors = bookClass.getDeclaredConstructors();

        // 获取 public 的默认无参构造函数
        Constructor<Book> constructor = bookClass.getConstructor(new Class[]{});

        // 获取默认无参构造函数
        Constructor<Book> declaredOne = bookClass.getDeclaredConstructor();

        System.out.println(bookClass.toGenericString());
    }
}
