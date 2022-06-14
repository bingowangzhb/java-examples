package com.bgw.reflection;

import com.bgw.reflection.beans.Father;
import org.junit.Test;

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

    @Test
    public void testClass() {
        Class<?>[] classes = Father.class.getClasses();
        Class<?>[] declaredClasses = Father.class.getDeclaredClasses();
        Class<?> declaringClass = Father.class.getDeclaringClass();

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

    @Test
    public void testMethod() {

        Method[] methods = Father.class.getMethods();
        Method[] declaredMethods = Father.class.getDeclaredMethods();

        System.out.println(" -------------getMethods()------------- ");
        Arrays.stream(methods).forEach(m -> {
            System.out.println("m.getName() = " + m.getName());
        });

        System.out.println(" -------------getDeclaredMethods()------------- ");
        Arrays.stream(declaredMethods).forEach(m -> {
            System.out.println("m.getName() = " + m.getName());
        });


    }

    @Test
    public void testField() {
        Field[] fields = Father.class.getFields();
        Field[] declaredFields = Father.class.getDeclaredFields();

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
