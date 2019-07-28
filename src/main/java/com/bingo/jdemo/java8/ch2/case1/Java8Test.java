package com.bingo.jdemo.java8.ch2.case1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/18 17:18
 */
public class Java8Test {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple("red", 1000),
                new Apple("blue", 1200),
                new Apple("green", 1500),
                new Apple("red", 1500),
                new Apple("green", 2000));

        List<Apple> result = filterGreenApples(inventory);
        //System.out.println(Arrays.toString(result.toArray()));
        System.out.println(result);


        List<Apple> result2 = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor()) && apple.getWeight() > 1200;
            }
        });
        System.out.println(result2);

        List<Apple> result3 = filterApples(inventory, (Apple a) -> a.getWeight() > 1500);
        System.out.println(result3);
    }


    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : inventory) {
            if ("green".equals(a.getColor())) {
                result.add(a);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
