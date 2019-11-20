package com.bgw.basic;

import com.bgw.jvm.classloader.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * TestConsumer
 *
 * @author zhibin.wang
 * @since 2019-11-05 10:38
 **/
public class TestConsumer implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }


    public static void main(String[] args) {
        Consumer<String> cs = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };


        Consumer<String> c = System.out::println;
        c.accept("Beijing");

        Supplier<String> s = () -> "postman";
        System.out.println(s.get());

        Function<String, Integer> fun = Integer::parseInt;
        System.out.println(fun.apply("300"));

        Predicate<Integer> p = (i) -> i > 100;
        System.out.println(p.test(40));

    }
}
