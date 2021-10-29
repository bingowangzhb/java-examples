package com.bgw.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaTestCase {


    public static void main(String[] args) {

        toMap();

    }


    static void peek() {
        List<Integer> ids = Arrays.asList(1, 3, 5, 4, 9);
        List<String> ss = ids.stream()
                .filter(t -> t > 2)
                .map(t -> "adc" + t)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }


    static void toMap() {

        List<Student> stus = new ArrayList<>(Arrays.asList(new Student("1", "A"), new Student("2", "B"), new Student("1", "C")));


        Map<String, Student> stuMap1 = stus.stream()
                .collect(Collectors.toMap(s -> s.getId(), Function.identity(), (a, b) -> a));


        Map<String, Student> stuMap2 = stus.stream()
                .collect(Collectors.toMap(s -> s.getId(), Function.identity(), (a, b) -> b));
        System.out.println("stuMap1 = " + stuMap1);
        System.out.println("stuMap2 = " + stuMap2);


        Map<String, String> stuMap3 = stus.stream()
                .collect(Collectors.toMap(s -> s.getId(), s -> s.getName(), (id, name) -> {
                    System.out.println("id = " + id);
                    System.out.println("name = " + name);

                    return "id";
                }));


        Map<String, String> stuMap4 = stus.stream()
                .collect(Collectors.toMap(s -> s.getId(), s -> s.getName(), (a, b) -> b + "," + a));
        System.out.println("stuMap3 = " + stuMap3);
        System.out.println("stuMap4 = " + stuMap4);
    }
}


/*
* 1.keyMapper：Key 的映射函数
* 2.valueMapper：Value 的映射函数
* 3.mergeFunction：当 Key 冲突时，调用的合并方法
* 4.mapSupplier：Map 构造器，在需要返回特定的 Map 时使用
* */