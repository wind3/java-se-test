package com.example.demospringboot2.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 加载系统资源，加载的内容必须是在编译后的 classes目录下
 */
public class ClassGetResource {
    public static void main(String[] args) throws IOException {
        // 通过 classLoader 加载应用内路径文件
/*
        InputStream resourceAsStream = ClassGetResource.class.getResourceAsStream("/static/index.html");

        InputStreamReader reader = new InputStreamReader(resourceAsStream);
        char[] buff = new char[1024];
        while (reader.read(buff) != -1){

            System.out.println(buff);
        }
*/

        // 通过Class 加载，/ 表示从根路径开始加载
//        InputStream in = ClassGetResource.class.getResourceAsStream("/com/example/demospringboot2/classloader/classLoader.html");
        // 通过Class 加载，相对路径表示从当前类所在的目录开始加载
//        InputStream in = ClassGetResource.class.getResourceAsStream("classLoader.html");
//        通过Class 加载，可以使用相对路径
//        InputStream in = ClassGetResource.class.getResourceAsStream("../reflection/index.html");

        // 通过classLoader加载，只能从根路径开始加载，并且不能以 / 开头
        InputStream in = ClassGetResource.class.getClassLoader().getResourceAsStream("com/example/demospringboot2/classloader/classLoader.html");
//        InputStream in = ClassGetResource.class.getClassLoader().getResourceAsStream("classpath:static/index.html");

        char[] buff = new char[1024];
        InputStreamReader re = new InputStreamReader(in);
        while (re.read(buff) != -1){
            System.out.println(buff);
        }
    }
}
