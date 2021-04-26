package com.bgw.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ArrayTest
 *
 * @author wang
 * @since 2020/7/17 23:42
 **/
public class ArrayTest {

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 6, 7};

        IntStream stream = Arrays.stream(a);
        List<Integer> nums = stream.boxed().sorted().collect(Collectors.toList());


        List list = Arrays.asList(a);

        System.out.println(list.size());
        System.out.println(list.get(0).getClass());


        List<Object> ll = new ArrayList<>();
        ll.add(1);
        ll.add(2);

        List<Integer> li = new ArrayList<>();
        for (Object obj : ll) {
            li.add((Integer)obj);
        }

        System.out.println("ll = " + ll);
        System.out.println("li.size() = " + li.size());


        int aa = 5;

        for (int i = 0; i < aa; i++) {
            System.out.println("new Random() = " + new Random().nextInt(aa));
        }

    }
}
