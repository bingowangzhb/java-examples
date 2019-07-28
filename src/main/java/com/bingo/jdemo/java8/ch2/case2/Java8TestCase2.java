package com.bingo.jdemo.java8.ch2.case2;

import com.bingo.jdemo.java8.ch2.case1.Apple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/19 9:26
 */
public class Java8TestCase2 {


    public static void main(String[] args) throws Exception {
        List<Apple> inventory = Arrays.asList(
                new Apple("red", 1000),
                new Apple("blue", 1200),
                new Apple("green", 1500),
                new Apple("red", 1500),
                new Apple("green", 2000));


//        inventory.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        System.out.println(inventory);
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
        inventory.sort(Apple::compareTo);
        System.out.println(inventory);
//        inventory.sort(Comparator.naturalOrder());
//        inventory.sort(Comparator.reverseOrder());
//
//        System.out.println(inventory);
//
//        process(() -> System.out.println(1));
//
//        // processFile((br) -> br.readLine());
//        processFile(BufferedReader::readLine);
//        processFile((br) -> br.readLine() + br.readLine());

//        List<Integer> list = map(inventory, (Apple a) -> a.getWeight());
//        System.out.println(list);



    }


    public static void process(Runnable r) {
        System.out.println(123);
        r.run();
    }

    public static Runnable getTask() {
        return () -> System.out.println(1);
    }

    public static Callable<String> fetch() {
        return () -> "abc";
    }


    public static String processFile(BufferedReaderProcessor brp) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("a.txt"))) {
            return brp.process(br);
        }
    }

    public static <T, R> List<R> map(List<T> sources, Function<T, R> fun) {
        List<R> result = new ArrayList<>();
        for (T t : sources) {
            result.add(fun.apply(t));
        }

        return result;
    }
}
