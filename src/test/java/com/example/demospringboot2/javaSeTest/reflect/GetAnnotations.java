package com.example.demospringboot2.javaSeTest.reflect;

import lombok.Data;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 从反射类型信息中，获取 注解信息
 * 1、获取 类上的所有注解，包括继承的
 * 2、获取 元素上的注解，不包括继承的
 * 3、获取 参数上的注解
 * 4、获取
 */
public class GetAnnotations {

    @Test
    public void getAnnotations() throws ClassNotFoundException {

        ClassLoader classLoader = Data.class.getClassLoader();
        Class<?> bookClazz = classLoader.loadClass("com.example.demospringboot2.javaSeTest.reflect.Book");

        Class<Book> bookClass = Book.class;

        Annotation[] annotations = bookClass.getAnnotations();

        Annotation[] declaredAnnotations = bookClass.getDeclaredAnnotations();

        Data data = bookClass.getDeclaredAnnotation(Data.class);

        Annotation[] clazzAnnotations = bookClazz.getAnnotations();

        Field[] fields = bookClass.getFields();

        System.out.println(annotations);
    }
}
