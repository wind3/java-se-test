package com.example.demospringboot2.javaSeTest.io;

import org.junit.Test;

import java.io.*;

/**
 * @Title: 字符流读写操作
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/4/3$ 23:56$
 */
public class JavaReadWriteIOTest {



    @Test
    public void readTest() throws IOException {
        String path = "C:\\" +
                "Users\\lovelin\\Desktop\\test.txt";

        String outPath = "C:\\" +
                "Users\\lovelin\\Desktop\\test-out.txt";
        //读取文件
        File file = new File(path);

        Reader reader = new FileReader(file);
        int length = 0;
        char[] cc = new char[512];
        while ((length = reader.read(cc)) != -1){
            System.out.println(cc);
        }

        //读取一个字符，c是字符的ascII码
        int c = reader.read();
        System.out.println((char)c);
    }
}
