package com.example.demospringboot2.javaSeTest.reflect;

import com.example.demospringboot2.javaSeTest.emun.StatusEnumTest;
import lombok.Data;
import org.junit.Test;

/**
 * 具有4种方式加载 Class对象
 */
public class ClassLoad {

    /**
     * Type.class
     */
    @Test
    public void classLoad1() {
        Class<Book> bookClass = Book.class;
        System.out.println(bookClass.getName());
    }

    /**
     * Class.forName("类的全路径名")
     * @throws ClassNotFoundException
     */
    @Test
    public void classLoad2() throws ClassNotFoundException {
        Class<Book> bookClass = (Class<Book> )Class.forName("com.example.demospringboot2.javaSeTest.reflect.Book");
        System.out.println(bookClass.getName());
    }

    @Test
    public void classLoad3() {
        Book book = new Book();
        Class<Book> bookClass = (Class<Book>) book.getClass();
        System.out.println(bookClass.getName());
    }

    @Test
    public void classLoad4() throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Class<Book> bookClazz = (Class<Book> ) contextClassLoader.loadClass("com.example.demospringboot2.javaSeTest.reflect.Book");
        System.out.println(bookClazz.getName());
    }


    @Test
    public void classType() {
        // 原始类型
        Class<Integer> integerClass = int.class;
        // 接口类型
        Class<Runnable> runnableClass = Runnable.class;
        // 枚举类型
        Class<StatusEnumTest> statusEnumTestClass = StatusEnumTest.class;
        // 数组类型
        Class<int[]> aClass = int[].class;
        // 注解类型
        Class<Data> dataClass = Data.class;

    }


}
