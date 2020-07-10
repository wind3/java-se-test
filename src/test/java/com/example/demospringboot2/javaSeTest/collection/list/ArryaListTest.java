package com.example.demospringboot2.javaSeTest.collection.list;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;

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
        Collections.emptyMap();
//        CollectionUtils.class

        List<String> strings = Arrays.asList(arr);
//        List<String> arrayList = new ArrayList<String>(arr);


//      遗留接口  可将 可枚举对象（被Iterable替代） 转为 list，
//        Collections.list();
    }
}
