package com.example.demospringboot2.classloader;

import java.io.*;

/**
 * 用户自定义classloader
 */
public class UserClassLoader extends ClassLoader {

    //加载路径
//    private String path = "F:\\gitWorkspace\\java-se-test\\target\\classes\\";
    private String path = "F:";
    //class文件的扩展名
    private final String fileType = ".class";

    private String name = "UserClassLoader";
    private UserClassLoader() {
    }

    public UserClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        Class<?> aClass = defineClass(name, classData, 0, classData.length);
        if (null == aClass){
            throw new ClassNotFoundException();
        }
        System.out.println("UserClassLoader findClass = " + name);
        return aClass;
    }

    /**
     * 根据 类全限定名，加载class文件 字节数组
     * @param name
     * @return
     */
    public byte[] loadClassData(String name){

        // 路径转换：类全限定名 . 转换为 访问路径 /
        String newname = name.replace(".", File.separator);

        try{
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(
                    new File(path + File.separator + newname + fileType)));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int ch = 0;
            while ( (ch = bufferedInputStream.read(buff))  != -1){
                // 从buff中读取数据，写入out
                out.write(buff, 0, ch);
            }
            // 从 out 中取出数据，转为 byte[]
            return out.toByteArray();
        }catch (Exception e){

        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        UserClassLoader loader = new UserClassLoader(ClassLoader.getSystemClassLoader());
//        UserClassLoader loader = new UserClassLoader();
        // 如果类中有package，则加载类名时，需要写全，不然找不到该类,会出现NOClassDefFoundError
        Class<?> aClass = loader.loadClass("com.example.demospringboot2.classloader.ClassGetResource");

        System.out.println(aClass.getName());
    }
}
