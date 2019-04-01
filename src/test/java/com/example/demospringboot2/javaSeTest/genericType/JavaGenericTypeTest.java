package com.example.demospringboot2.javaSeTest.genericType;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 泛型
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/3/31$ 10:41$
 */
public class JavaGenericTypeTest {

    @Test
    public void test( ){
       String e = this.<String>param("123");


       //给了实际类型后，才能执行该类型的操作
       JavaGenericInterfaceTest<Car> test = new JavaExtendsTest<Car>(new Car("new car"));
       Car car =  test.test();
       System.out.println(car);
    }


    public  <E> E param(E param){
        System.out.print(param);
        return  param;
    }


}
