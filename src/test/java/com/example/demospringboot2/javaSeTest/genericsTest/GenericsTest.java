package com.example.demospringboot2.javaSeTest.genericsTest;

import org.junit.Test;

import java.util.*;

/**
 * @Title: 泛型体系
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/12/3$ 21:29$
 */
public class GenericsTest {

    @Test
    public void test(){

        int i = 0;
        tag: for ( i = 0; i <10 ; i++){
            for (int j = 0; j <10 ; j++){
                System.out.println("j = " + j);
                if (j == 5){
                    break tag;
                }
            }
            //得不到执行
            System.out.println("i = " + i);
        }

        System.out.println("i = " + i);
    }

    @Test
    public void test1(){
        byte b = 0;
        int i = 0;
        String n = "";
        long lo = 0L;
        switch (b){
            case 0 :  System.out.println("b = " + b);

        }
        switch (n){
            case "1":  System.out.println("n = " + n);

        }
        switch (i){
            case  0 : System.out.println("i = " + b);
            case  1 : System.out.println("i = " + b);
        }

      /*  switch (lo){
            case 1: break;
        }*/
    }

    @Test
    public void test2(){
        short i = 1;
        //类型转换错误，i + 1是int类型，i + 1 隐式转换为short报错
//        i = i + 1;
        i = 1 + 1;
        //正确，隐含了默认强转，i = (short) (i+1)
        i += 1;
        i = (short) (i+1);

        char c = '中';
        System.out.println("i = " + c);

        int i1 = 7 ^ 3;
        System.out.println("亦或 = " + i1);
        int i2 = 7 & 3;
        System.out.println("按位与 = " + i2);
        int i3 = 2 << 9;
        System.out.println("有符号左移 = " + i3);
        //有符号右移，符号位不变
        int i4 = 16 >> 2;
        System.out.println("有符号右移 = " + i4);
        //不存在无符号左移<<<
        int i5 = 16 >>> 4;
        System.out.println("无符号右移 = " + i5);
        //int是4字节，32位，无符号右移，高位补0
        int i6 = -1 >>> 31;
        System.out.println("无符号右移 = " + i6);
        //int强转为byte
        byte b1 = (byte) i2;
        System.out.println("int强转为byte = " + b1);
        byte b2 = (byte) 256;
        System.out.println("int强转为byte = " + b2);
    }

    @Test
    public void test3(){
        List list = null;
        Vector vector = null;
        Hashtable hashtable = new Hashtable();
        hashtable.put("1","2");
        TreeMap treeMap = null;
//        Collections
        StringBuffer stringBuffer=null;

    }
}
