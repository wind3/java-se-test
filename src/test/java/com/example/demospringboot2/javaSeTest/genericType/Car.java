package com.example.demospringboot2.javaSeTest.genericType;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: zengwj
 * @CreateTime: 2019-04-01$ 17:50$
 */
public class Car {

    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){

        return this.name;
    }
}
