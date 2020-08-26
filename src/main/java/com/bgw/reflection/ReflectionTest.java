package com.bgw.reflection;

import lombok.SneakyThrows;

/**
 * ReflectionTest
 *
 * @author zhibin.wang
 * @since 2020/08/21 16:04
 */
public class ReflectionTest {

    public static void main(String[] args) throws Exception {

        Class<Person> cp = Person.class;

        System.out.println("cp.toString() = " + cp.toString());
        System.out.println("cp.toGenericString() = " + cp.toGenericString());

        Class<?> aClass = Class.forName("com.bgw.reflection.Person");
        System.out.println("aClass.getName() = " + aClass.getName());
        aClass.newInstance();

    }
}
