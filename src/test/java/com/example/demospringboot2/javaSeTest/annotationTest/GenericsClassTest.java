package com.example.demospringboot2.javaSeTest.annotationTest;

import java.util.List;

/**
 * @Title: 泛型类
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/12/3$ 21:31$
 */
public  class   GenericsClassTest <T> {

    public T get(T t){
        return t;
    }

    public List<? extends T>  select(  List<? extends T>  type){
        return type;
    }

    public List<? super T>  selectOne(  List<? super T>  type){
        return type;
    }

/*    public <? super T>  selectOne(  <? super T>  type){
        return type;
    }*/
}
