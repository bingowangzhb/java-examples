package com.bgw.java8.stream.eg01;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author zhibin.wang
 */
public class StreamTestCase {
    public static void main(String[] args) {
        List<String> names = Collections.singletonList("James");
        // System.out.println(names.stream().findAny().get());


        List<Integer> list = new ArrayList<>();

        int max = list.stream()
                .max(Integer::compareTo)
                .orElse(-1);

        System.out.println("max = " + max);


        int a = 0;
        int b = 1;
        int c = 1;

        if (a == 0 && b == 0 && c == 0) {

        }
        else {
            if (a == 1) {
                System.out.println("a = " + a);
            }
            else if (b == 1) {
                System.out.println("b = " + b);
            }
            else if (c == 1) {
                System.out.println("c = " + c);
            }
        }



    }


    @Test
    public void testStreamReducing() {
        List<Order> orders = Arrays.asList(new Order("1", new BigDecimal(2), new BigDecimal(3)),
                new Order("2", new BigDecimal(4), new BigDecimal(6)),
                new Order("3", new BigDecimal(5), new BigDecimal(9)));

        BigDecimal sum = orders.stream()
                .map(o -> o.getProductAmount().add(o.getServiceAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("sum = " + sum);
        orders.forEach(System.out::println);

        List<String> orderIds = orders.stream()
                .map(Order::getOrderId)
                .collect(Collectors.toList());
        System.out.println(orderIds);

        String ids = String.join(",", orderIds);
        System.out.println(ids);

        String ids2 = orders.stream()
                .map(Order::getOrderId)
                .collect(Collectors.joining(","));
        System.out.println(ids2);


    }
}
