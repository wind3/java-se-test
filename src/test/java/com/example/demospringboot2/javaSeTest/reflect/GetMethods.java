package com.example.demospringboot2.javaSeTest.reflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 从反射类型信息中，获取方法
 * 1、可获取所有public 方法，包括自身声明的、继承的、接口实现的公共方法
 * 2、可获取所有声明的方法，包括private，包括自身声明的、接口实现的，不包括继承的
 * 3、可获取 public的具名方法
 * 4、可获取声明的具名方法
 *
 */
public class GetMethods {

    @Test
    public void getMethods() throws NoSuchMethodException {

        Class<Book> bookClass = Book.class;

        // 可获取所有public 方法，包括自身声明的、继承的、接口实现的公共方法
        Method[] publicMethods = bookClass.getMethods();

        // 可获取所有声明的方法，包括private，包括自身声明的、接口实现的，不包括继承的
        Method[] allDeclaredMethods = bookClass.getDeclaredMethods();

        // 获取具名的public方法，指明参数的类型信息
        Method getName = bookClass.getMethod("getName", new Class<?>[]{});

        // 获取 具名的声明方法，包括 非public 方法
        Method getPrice = bookClass.getDeclaredMethod("setPrice", Integer.class);

    }


}
