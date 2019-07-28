package com.bingo.jdemo.classloader;

/**
 * 说明：Test
 *
 * @author ShujuboDev
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println("Hello Test");
    }

    public void sayHello() {
        System.out.println("HelloWorld!");
        System.out.println(this.getClass().getClassLoader());
    }
}
