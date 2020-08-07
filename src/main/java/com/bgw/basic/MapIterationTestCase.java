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

    private final static Map<String, String> MAP = new HashMap<>(8);

    static {
        MAP.put("13", "James Harden");
        MAP.put("24", "Kobe Bryant");
        MAP.put("23", "LeBron James");
        MAP.put("1", "Tracy McGrady");
        MAP.put("30", "Stephen Curry");
        MAP.put("11", "Yao Ming");
        MAP.put("3", "Dwyane Wade");
    }


    public static void main(String[] args) {
        // 推荐使用EntrySet和java8的Map.forEach
        // visitWithIterationEntrySet();
        // visitWithIterationKeySet();
        // visitWithForEachEntrySet();
        //visitWithForEachKeySet();
        // visitWithLambda();
    }

    private static void visitWithIterationEntrySet() {
        for (Map.Entry<String, String> player : MAP.entrySet()) {
            System.out.println("No:" + player.getKey());
            System.out.println("Name:" + player.getValue());
        }

    }

    private static void visitWithIterationKeySet() {
        for (String key : MAP.keySet()) {
            System.out.println("No:" + key);
            System.out.println("Name:" + MAP.get(key));
        }

    }

    private static void visitWithForEachEntrySet() {
        for (Map.Entry<String, String> player : MAP.entrySet()) {
            System.out.println("No:" + player.getKey());
            System.out.println("Name:" + player.getValue());
        }

    }

    private static void visitWithForEachKeySet() {
        for (String key : MAP.keySet()) {
            System.out.println("No:" + key);
            System.out.println("Name:" + MAP.get(key));
        }

    }

    private static void visitWithLambda() {
        MAP.forEach((k, v) -> {
            System.out.println("No:" + k);
            System.out.println("Name:" + v);
        });

        MAP.keySet().removeIf(key -> key.equals("22"));
    }

    private static void visitWithStream() {
        MAP.entrySet().stream().forEach(entry -> {
            System.out.println("No:" + entry.getKey());
            System.out.println("Name:" + entry.getValue());
        });
    }

    private static void visitWithParallelStream() {
        MAP.entrySet().parallelStream().forEach(entry -> {
            System.out.println("No:" + entry.getKey());
            System.out.println("Name:" + entry.getValue());
        });
    }


}
