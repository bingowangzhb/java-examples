package com.bgw.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ReflectionTest
 *
 * @author zhibin.wang
 * @since 2020/08/21 16:04
 */
public class ReflectionTest {

    public static void main(String[] args) throws Exception {

        testClass();
        testField();
        testMethod();

    }

    private static void testClass() {
        Class[] classes = Man.class.getClasses();
        Class[] declaredClasses = Man.class.getDeclaredClasses();
        Class declaringClass = Man.class.getDeclaringClass();

        System.out.println(" -------------getClasses()------------- ");
        Arrays.stream(classes).forEach(c -> {
            System.out.println("c.getName() = " + c.getName());
        });

        System.out.println(" -------------getDeclaredClasses()------------- ");
        Arrays.stream(declaredClasses).forEach(c -> {
            System.out.println("c.getName() = " + c.getName());
        });

        System.out.println(" -------------getDeclaringClass()------------- ");
        System.out.println("declaringClass = " + declaringClass);
    }

    private static void testMethod() {

        Method[] methods = Man.class.getMethods();
        Method[] declaredMethods = Man.class.getDeclaredMethods();

        System.out.println(" -------------getMethods()------------- ");
        Arrays.stream(methods).forEach(m -> {
            System.out.println("m.getName() = " + m.getName());
        });

        System.out.println(" -------------getDeclaredMethods()------------- ");
        Arrays.stream(declaredMethods).forEach(m -> {
            System.out.println("m.getName() = " + m.getName());
        });


    }

    private static void testField() {
        Field[] fields = Man.class.getFields();
        Field[] declaredFields = Man.class.getDeclaredFields();

        System.out.println("fields = " + fields.length);

        Arrays.stream(fields).forEach(f -> {
            System.out.println("f.getName() = " + f.getName());
        });

        System.out.println(" ------------------------------ ");
        System.out.println("declaredFields = " + declaredFields.length);
        Arrays.stream(declaredFields).forEach(f -> {
            System.out.println("f.getName() = " + f.getName());
        });
    }
}
