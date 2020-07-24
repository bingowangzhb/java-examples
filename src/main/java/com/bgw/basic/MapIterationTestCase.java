package com.bgw.basic;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * MapIterationTestCase
 *
 * @author wang
 * @since 2020/5/17 22:06
 **/
public class MapIterationTestCase {

    private static Map<String, String> map = new HashMap<>(16);

    static {
        map.put("13", "James Harden");
        map.put("24", "Kobe Bryant");
        map.put("23", "LeBron James");
        map.put("1", "Tracy McGrady");
        map.put("30", "Stephen Curry");
        map.put("11", "Yao Ming");
        map.put("3", "Dwyane Wade");
    }


    public static void main(String[] args) {
        // visitWithIterationEntrySet();
        // visitWithIterationKeySet();
        // visitWithForEachEntrySet();
        //visitWithForEachKeySet();
        // visitWithLambda();
    }

    private static void visitWithIterationEntrySet() {
        for (Map.Entry<String, String> player : map.entrySet()) {
            System.out.println("No:" + player.getKey());
            System.out.println("Name:" + player.getValue());
        }

    }

    private static void visitWithIterationKeySet() {
        for (String key : map.keySet()) {
            System.out.println("No:" + key);
            System.out.println("Name:" + map.get(key));
        }

    }

    private static void visitWithForEachEntrySet() {
        for (Map.Entry<String, String> player : map.entrySet()) {
            System.out.println("No:" + player.getKey());
            System.out.println("Name:" + player.getValue());
        }

    }

    private static void visitWithForEachKeySet() {
        for (String key : map.keySet()) {
            System.out.println("No:" + key);
            System.out.println("Name:" + map.get(key));
        }

    }

    private static void visitWithLambda() {
        map.forEach((k, v) -> {
            System.out.println("No:" + k);
            System.out.println("Name:" + v);
        });

        map.keySet().removeIf(key -> key.equals("22"));
    }

    private static void visitWithStream() {
        map.entrySet().stream().forEach(entry -> {
            System.out.println("No:" + entry.getKey());
            System.out.println("Name:" + entry.getValue());
        });
    }

    private static void visitWithParallelStream() {
        map.entrySet().parallelStream().forEach(entry -> {
            System.out.println("No:" + entry.getKey());
            System.out.println("Name:" + entry.getValue());
        });
    }


}
