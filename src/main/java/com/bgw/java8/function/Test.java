package com.bgw.java8.function;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * @author ambow
 * @since 2021/12/21 14:20
 */
public class Test {


    public static void main(String[] args) {

        Map<String, Integer> m1 = new HashMap<>();
        m1.put("count", 1);

        Map<String, Integer> m2 = new HashMap<>();
        m2.put("count", 3);

        Map<String, Integer> m3 = new HashMap<>();
        m3.put("count", 3);

        List<Map<String, Integer>> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
    }



}
