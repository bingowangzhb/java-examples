package com.bgw.java8.stream.example01;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhibin.wang
 */
public class StreamTestCase {
    public static void main(String[] args) {
        List<String> names = Collections.singletonList("James");
        System.out.println(names.stream().findAny().get());
    }


    @Test
    public void testStreamReducing() {
        List<Order> orders = Arrays.asList(new Order("1", new BigDecimal(2), new BigDecimal(3)),
                new Order("2", new BigDecimal(4), new BigDecimal(6)),
                new Order("3", new BigDecimal(5), new BigDecimal(9)));



        //orders.stream().reduce((o1, o2) -> o1.getServiceAmount().add(o1.getProductAmount()))


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
