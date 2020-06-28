package com.example.demospringboot2.javaSeTest.collection.list;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/25$ 8:48$
 */
public class ArryaListTest extends RuntimeException{

    @Test
    public void test(){
        String[] arr = new String[]{"a","b","x","p"};
        Set<String> set = Collections.emptySet();
        set.add("a");
        set.add("z");
        set.add("d");


//      遗留接口  可将 可枚举对象（被Iterable替代） 转为 list，
//        Collections.list();
    }
}
