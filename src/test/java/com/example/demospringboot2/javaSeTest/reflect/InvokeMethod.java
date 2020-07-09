package com.example.demospringboot2.javaSeTest.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 从反射类型信息中，实例化对象，并调用其方法
 */
public class InvokeMethod {

    @Test
    public void invokeMethod() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Book book = new Book();
        book.setName("金瓶梅");
        book.setPrice(100);

        Class<Book> bookClass = (Class<Book>) book.getClass();

        Method getName = bookClass.getDeclaredMethod("getName", new Class[]{});

        System.out.println(getName.invoke(book,null));

        // 获取 public 的默认无参构造函数
        Constructor<Book> constructor = bookClass.getConstructor(new Class[]{});

        Book instance = constructor.newInstance(null);
        instance.setName("水浒传");
        instance.setPrice(200);

        System.out.println(getName.invoke(instance,null));
    }

}
