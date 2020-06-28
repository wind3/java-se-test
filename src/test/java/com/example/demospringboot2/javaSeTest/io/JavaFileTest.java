package com.example.demospringboot2.javaSeTest.io;

import org.junit.Test;

import java.io.*;

/**
 * @Title: 文件
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/4/1$ 23:39$
 */
public class JavaFileTest {

    @Test
    public void testFileIO() throws IOException {
        String path = "C:\\" +
                "Users\\lovelin\\Desktop\\test.txt";

        String outPath = "C:\\" +
                "Users\\lovelin\\Desktop\\test-out.txt";
        //读取文件
        File file = new File(path);
        BufferedInputStream in = null;

        //输出文件
        File outFile = new File(outPath);
        BufferedOutputStream out = new BufferedOutputStream( new FileOutputStream(outFile));
        try {
            //缓冲输入流，过程：先将文件读取到缓冲
            in = new BufferedInputStream(new  FileInputStream(file));
            //临时数据区，作为输入流、输出流的中转站，必须要有
            byte[] b = new byte[1024];
            int length = 0;
            while ((length = in.read(b)) != -1){
                //将临时数据区b的数据，写到输出流的缓冲区
                out.write(b,0,length);
                //将ascii码值为100的字符写到文件
              //  out.write(100);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if ( in != null){
                in.close();
            }
            if (out != null){
                //输出流关闭时，自动flush，将缓冲区的数据刷新到磁盘文件
                out.close();
            }
        }
    }

    @Test
    public void testFileSystem() throws IOException {
        String path = "C:\\" +
                "Users\\lovelin\\Desktop\\test.txt";

        String outPath = "C:\\" +
                "Users\\lovelin\\Desktop\\test-out.txt";
        //读取文件
        File file = new File(path);
        File outFile = new File(outPath);
        InputStream in = null;
        OutputStream out =  new FileOutputStream(outFile);
        try {
            in = new FileInputStream(file);
            byte[] b = new byte[1024];
            while(in.read(b) != -1){
                out.write(b);
                System.out.println(new String(b));
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if ( in != null){
                in.close();
            }
            if (out != null){
                out.close();
            }
        }
    }


    @Test
    public void test(){

        String path = "C:\\" +
                "Users\\lovelin\\Desktop";
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
