package com.example.demospringboot2.paramInfo;

import org.springframework.stereotype.Component;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/3/31$ 16:05$
 */

interface Eat{}
interface Sleep{
    void sleep();
}

class Animal{
    protected String name;
    Animal(){}

    Animal(String name){
        this.name = name;
        System.out.print(name);
    }
}

@Deprecated
@Component
public class Dog extends Animal implements Eat,Sleep{

    private String age;
    protected String sex;
    public String home;

    public Dog(){super();}

    public Dog(String name){
        super(name);
    }

    public String say(){
        System.out.println("dog say hello");
        return "dog say hello";
    }

    private void laugh(){}

    @Override
    public void sleep() {

    }
}
