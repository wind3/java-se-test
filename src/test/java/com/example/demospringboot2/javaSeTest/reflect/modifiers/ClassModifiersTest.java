package com.example.demospringboot2.javaSeTest.reflect.modifiers;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Class 对象的修饰符
 */
public class ClassModifiersTest<T> implements Serializable {

    public String name;
    public static void main(String[] args) {
        Class<ClassModifiersTest> a = ClassModifiersTest.class;
        System.out.println(a.getModifiers());

        TypeVariable<Class<ClassModifiersTest>>[] typeParameters = a.getTypeParameters();
        System.out.println(typeParameters);

        Type[] genericInterfaces = a.getGenericInterfaces();
        System.out.println(genericInterfaces);

        Class<?>[] classes = a.getClasses();
        System.out.println(classes);
    }

}
