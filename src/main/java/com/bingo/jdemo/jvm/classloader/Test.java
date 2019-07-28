package com.bingo.jdemo.classloader;

import static java.lang.Thread.currentThread;

/**
 * 说明：Test
 *
 * @author ShujuboDev
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello Test");

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                // your codes
            }, "ThreadName").start();
        }

    }

    public void sayHello() {
        System.out.println("HelloWorld!");
        System.out.println(currentThread().getName() + "\t ");
    }
}
