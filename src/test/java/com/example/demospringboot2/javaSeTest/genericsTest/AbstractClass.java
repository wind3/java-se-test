package com.example.demospringboot2.javaSeTest.genericsTest;

import java.io.Serializable;

/**
 * @Title: TODO
 * @Description:
 *
 * 接口可以继承多个接口，extends；
 * 抽象类可以实现多个接口，implements；
 * 抽象类可以继承具体类；
 * 抽象类可以有main方法；
 *
 * @Author: lovelin
 * @CreateTime: 2019/12/10$ 0:06$
 */
public abstract class AbstractClass extends ConcreteClass implements Serializable {
    public static void main(String[] args){
        System.out.println("1");
    }

    private String doS(){
        return "";
    }
}
