package com.example.demospringboot2.javaSeTest.basicType;

import org.junit.Test;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/25$ 9:48$
 */
public class StringTest {

    @Test
    public void test(){
        //没必要这么用，建议使用 ""
        String string = new String();
        String emp = "";
        String str = "中国人";
        String num = String.valueOf(10);
        String ch = Character.toString('c');
        String list = new Object().toString();

//        支持Unicode ，返回 国
        char c = str.charAt(1);
        // 获取所在位置的字符的 10位unicode编码
        int i = str.codePointAt(1);
        System.out.println(c);
        System.out.println(i);

//        字符串匹配比较，可以精细到 指定区间比较
        String reg = "System.out.println";
        String other = "Character OUT of test";
        boolean matches = reg.regionMatches(true, 7, other, 10, 3);
        System.out.println(matches);

//
        boolean test = other.endsWith("test");


        String regex = "[a-z]+";
//        等于 Pattern.matches(regex, "test");
        boolean matches1 = "test".matches(regex);

        System.out.println(matches1);

    }

    /**
     * format占位符格式： %[argument_index$][flags][width][.precision]conversion
     *
     * argument_index: 可选，是一个十进制整数，用于表明参数在参数列表中的位置。第一个参数由 "1$" 引用，第二个参数由 "2$" 引用，依此类推。
     *
     * flags: 可选，用来控制输出格式
     *
     * width: 可选，是一个正整数，表示输出的最小长度
     *
     * precision:可选，用来限定输出的精度
     *
     * conversion:必须，用来表示如何格式化参数的字符
     *
     *
     */
    @Test
    public void strFormat(){
        String temp = "this is %1$2s";
        String format = String.format(temp, "zengwj");
        System.out.println(format);
    }
}
