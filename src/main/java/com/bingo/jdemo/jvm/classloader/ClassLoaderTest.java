package com.bingo.jdemo.classloader;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 说明：ClassLoderTest
 *
 * @author ShujuboDev
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader2 = String.class.getClassLoader();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = List.class.getClassLoader();
        System.out.println(classLoader3);

        ClassLoader classLoader4 = long.class.getClassLoader();
        System.out.println(classLoader4);


        List<String> list = new CopyOnWriteArrayList<>();
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        // queue.put("as");
        queue.offer("ss");

    }

    public void test() {
        System.out.println("aaaaaaa");
    }


}
