package com.annotation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 说明：HelloWorld
 *
 * @author ShujuboDev 2019/5/24 15:26
 */
public class HelloWorld {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();

        List<String> list = new ArrayList<>();
        System.out.println(list.hashCode());
        list.add("a");
        System.out.println(list.hashCode());
        list.add("c");
        System.out.println(list.hashCode());
    }
}
