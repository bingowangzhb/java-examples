package com.steam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/19 10:19
 */
public class SteamTestCase {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(8, 1, 2, 1, 3, 3, 2, 4, 6);
//        numbers.stream()
//                .filter(i -> i % 2 == 0)
//                .distinct()
//                .forEach(System.out::println);


        List<String> words = Arrays.asList("Java8", "Lambda", "In", "Action", "Hello");
        //words.stream().map(String::length).forEach(System.out::println);



        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);


        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("selfk", "lKntw");

        Optional<Object> value = Optional.ofNullable(dataMap.get("key"));

        Byte a = Byte.MIN_VALUE;
        Integer b = Integer.MIN_VALUE;



    }
}
