package com.example.demospringboot2.javaSeTest;

import com.example.demospringboot2.paramInfo.Dog;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Title: 反射机制
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/3/31$ 23:13$
 */
public class JavaReflectTest {

    @Test
    public void test(){
        try {
            Class<?> dogClass = Class.forName("com.example.demospringboot2.paramInfo.Dog");
            Method[] methods =  dogClass.getDeclaredMethods();
            Dog dog = (Dog) dogClass.newInstance();
            for (Method method : methods){
                int modifiers = method.getModifiers();
                if (Modifier.isPublic(modifiers)){
                    method.invoke(dog);
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
