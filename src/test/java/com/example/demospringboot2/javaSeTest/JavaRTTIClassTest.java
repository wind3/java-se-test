package com.example.demospringboot2.javaSeTest;

import com.example.demospringboot2.paramInfo.Dog;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Title: 运行时类型信息测试
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/3/31$ 15:48$
 */
public class JavaRTTIClassTest {

    @Test
    public void test(){
        Class<Dog> dogClass = null;
        try {
             dogClass = (Class<Dog>) Class.forName("com.example.demospringboot2.paramInfo.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        JavaRTTIClassTest.printInfo(dogClass);

        try {
            Dog dog = dogClass.newInstance();
            System.out.println(dog.say());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Class<? extends Number> num = int.class;
        Class<?> num1 = int.class;
        num1 = double.class;
        System.out.println(num1.getName());
    }




    public static void printInfo(Class<?> clazz){
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getCanonicalName());
        System.out.println(clazz.getTypeName());

        System.out.println(clazz.isInterface());

        Class<?>[] cc = clazz.getClasses();
        if (cc != null){
            for (Class c : cc) {
                System.out.println(c.getName());
            }
        }

        Class<?>[] ff = clazz.getInterfaces();
        if (ff != null){
            for (Class f : ff) {
                System.out.println(f.getName());
            }
        }

        /**
         * 获得所有有权限访问的属性数组
         */
        Field[] fields = clazz.getFields();
        if (fields != null){
            for (Field f : fields) {
                System.out.println(f.getName());
            }
        }

        /**
         * 获取所有声明的属性，包括私有属性
         */
        Field[] declaredFields = clazz.getDeclaredFields();
        if (declaredFields != null){
            for (Field f : declaredFields) {
                System.out.println(f.getName());
            }
        }

        /**
         * 获得所有有权限访问的方法数组，包括Object的方法
         */
        Method[] methods = clazz.getMethods();
        if (methods != null){
            for (Method f : methods) {
                System.out.println(f.getName());
            }
        }
        /**
         * 获得所有该类或接口声明的方法：包括私有方法
         */
        Method[] methods1 = clazz.getDeclaredMethods();
        if (methods1 != null){
            for (Method f : methods1) {
                System.out.println(f.getName());
                //获取方法的修饰符编码
                int modifiers = f.getModifiers();
                boolean aPublic = Modifier.isPublic(modifiers);
                //获取方法的参数
                Class<?>[] parameterTypes = f.getParameterTypes();
                for (Class c : parameterTypes){
                    System.out.println(c.getName());
                }

            }
        }
        /**
         * 获得所有该类使用的注解
         */
        Annotation[] annotations = clazz.getAnnotations();
        if (annotations != null){
            for (Annotation f : annotations) {
                System.out.println(f.toString());
            }
        }

        /**
         * 获取所有构造函数
         */

    }

}
