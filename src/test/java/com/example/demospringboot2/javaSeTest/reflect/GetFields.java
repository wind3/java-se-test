package com.example.demospringboot2.javaSeTest.reflect;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 从反射类型信息中获取 属性
 * 1、只获取 public 属性
 * 2、获取 所有声明属性
 * 3、获取 具名 属性
 * 4、设置 private 属性可访问
 */
@Slf4j
public class GetFields {

    @Test
    public void getFields() throws NoSuchFieldException {
        Class<Book> bookClass = Book.class;

        Field[] publicFields = bookClass.getFields();
        log.info("{}",publicFields);

        Field[] allDeclaredFields = bookClass.getDeclaredFields();
        log.info("{}",allDeclaredFields);

        // 没有此public属性
//        Field nameField = bookClass.getField("name");
//        Assert.assertNull(nameField);

        Field name = bookClass.getDeclaredField("name");
        Assert.assertNotNull(name);

        // 不检查权限，允许访问该属性
        name.setAccessible(true);
    }

}
