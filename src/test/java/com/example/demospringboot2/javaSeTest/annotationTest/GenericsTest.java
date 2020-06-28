package com.example.demospringboot2.javaSeTest.annotationTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/12/3$ 21:34$
 */
public class GenericsTest {


    @Test
    public void test(){
        GenericsClassTest<String> test = new GenericsClassTest();
        String s = test.get("123");
        System.out.println(s);
    }

    @Test
    public void test1(){
        //延后泛型的指定到实例化
        GenericsClassImplementsInterfaceTest<String> test = new GenericsClassImplementsInterfaceTest("123");
//        GenericsClassImplementsInterfaceTest<int> test = new GenericsClassImplementsInterfaceTest(123);
        String s = test.select();
        System.out.println(s);
    }

    @Test
    public void test2(){
        //实现接口时指定类型
        GenericsClassImplementsInterfaceTest2 test = new GenericsClassImplementsInterfaceTest2("123");
        String s = test.select();
        System.out.println(s);
    }



    @Test
    public void test3(){
        //泛型方法
        GenericsTypeTest test = new GenericsTypeTest();
        test.<List<String>>exec(new ArrayList<>());
    }


}
