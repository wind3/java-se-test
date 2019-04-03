package com.example.demospringboot2.javaSeTest.io;

import org.junit.Test;

import java.io.*;
import java.nio.file.FileSystem;

/**
 * @Title: 文件
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/4/1$ 23:39$
 */
public class JavaFileTest {

    @Test
    public void testFileSystem(){
        //读取文件
        File file = new File("");
        try {
            InputStream in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test(){

        String path = "C:\\Users\\lovelin\\Desktop";
        String name = "fileTest.txt";
        String dir = "zeng";
        //读取文件
        File in = new File(path + File.separator + name);
        File in2 = new File(path + File.separator + "new" + name );

        in.renameTo(in2);

        System.out.println(in.getAbsolutePath());
        System.out.println(in.getName());
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
        System.out.println(File.pathSeparatorChar);

        File dd = new File(path,dir);
        File ee = new File(path,"li");
        if (dd.mkdirs()){
            System.out.println(dd.getName());
        }else {
            System.out.println(dd.isDirectory());
        }

        System.out.println(dd.renameTo(ee));
    }

    @Test
    public void testFile() throws IOException {

        String prefix = "fileTest11";
        String suffix = "txt";
        //读取文件
        File in = null;
        try {
            //生成临时文件
            in = File.createTempFile(prefix,suffix);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(in.getAbsolutePath());
        System.out.println(in.getName());
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
        System.out.println(File.pathSeparatorChar);
        System.out.println(in.canWrite());
        System.out.println(in.canRead());
        System.out.println(in.getCanonicalPath());

    }
}
