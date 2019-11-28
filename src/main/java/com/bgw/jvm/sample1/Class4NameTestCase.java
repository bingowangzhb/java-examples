package com.bgw.jvm.sample1;

/**
 * Class4NameTestCase
 *
 * @author zhibin.wang
 * @since 2019-11-22 14:50
 **/
public class Class4NameTestCase {
    private static final String CLASS_A_NAME = "com.bgw.jvm.sample1.ClassA";
    public static void main(String[] args) {
        refectInstance();
        //loadOnly();
        //loadThenInitialize();
        //print99MultipleTbl();

    }

    private static void refectInstance() {
        Class<?> clazz = null;
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
            // just load class, not run static code block
            clazz = classLoader.loadClass(CLASS_A_NAME);

            // invoke both static code block and constructor method
            ClassA a = (ClassA) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void loadOnly() {
        try {
            Class.forName(CLASS_A_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void loadThenInitialize() {
        try {
            Class.forName(CLASS_A_NAME, false, Class4NameTestCase.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void print99MultipleTbl() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + i * j + " ");
            }
            System.out.println();
        }
    }
}
