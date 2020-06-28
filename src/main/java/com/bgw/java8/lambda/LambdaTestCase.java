package com.bgw.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaTestCase {


    public static void main(String[] args) {

        List<Integer> ids = Arrays.asList(1, 3, 5, 4, 9);
        List<String> ss = ids.stream()
                .filter(t -> t > 2)
                .map(t -> "adc" + t)
                .peek(t -> System.out.println(t))
                .collect(Collectors.toList());
    }
}
