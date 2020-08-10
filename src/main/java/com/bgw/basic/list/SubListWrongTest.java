package com.bgw.basic.list;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * SubListWrongTest
 *
 * @author wang
 * @since 2020/7/27 22:33
 **/
public class SubListWrongTest {

    private static List<List<Integer>> data = new ArrayList<>();

    private static void oom() {
        for (int i = 0; i < 1000; i++) {
            List<Integer> rawList = IntStream.rangeClosed(1, 10000000).boxed().collect(Collectors.toList());
            data.add(rawList.subList(0, 1));
        }
    }

    private static void strongRef() {

        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        List<Integer> subList = list.subList(1, 4);
        System.out.println(subList);
        subList.remove(1);
        System.out.println(list);
        list.add(0);
        try {
            subList.forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //oom();
        // strongRef();
        String ss = "SSSSSSSSSSSSSSSSSSSSSSS";
        System.out.println(ObjectSizeCalculator.getObjectSize(ss));

    }
}
