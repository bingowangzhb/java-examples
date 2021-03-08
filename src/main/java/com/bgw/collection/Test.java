package com.bgw.collection;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 说明：Test
 *
 * @author ShujuboDev 2019/6/25 17:47
 */
public class Test {

    public static void main(String[] args) {

        List<List<String>> keywords1 = Arrays.stream("4,four".split("#"))
                .filter(StringUtils::isNotBlank)
                .map(k -> Arrays.stream(k.split(",")).collect(Collectors.toList()))
                .collect(Collectors.toList());

        List<List<String>> keywords2 = Arrays.stream("David#policemen#thief".split("#"))
                .filter(StringUtils::isNotBlank)
                .map(k -> Arrays.stream(k.split(",")).collect(Collectors.toList()))
                .collect(Collectors.toList());

        List<List<String>> keywords3 = Arrays.stream("A".split("#"))
                .filter(StringUtils::isNotBlank)
                .map(k -> Arrays.stream(k.split(",")).collect(Collectors.toList()))
                .collect(Collectors.toList());

        String answer = "David,policemen";

        boolean isMatch = keywords2.stream()
                .allMatch(candidate -> candidate.stream()
                        .anyMatch(answer::contains));

        System.out.println("isMatch = " + isMatch);




        String answer3 = "A";

        long l = keywords3.stream().filter(c -> c.stream()
                .anyMatch(answer3::contains)).count();
        boolean lMatch = keywords3.stream()
                .allMatch(candidate -> candidate.stream()
                        .anyMatch(answer3::contains));

        int temp1 = 100;
        int temp2 = 30;

        int temp = 23;

        String str = "james";
        System.out.println(temp2);
        decrement(200);
    }

    public static void decrement(int money) {
        int total = 500;
        String k = "key";
        int x = 1;
        int y = 39;

        money = total - money;
    }



}
