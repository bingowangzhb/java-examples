package com.bgw.java8.practice.ch3;

/**
 * LambdaTest
 *
 * @author zhibin.wang
 * @since 2020/11/21 16:25
 */
public class LambdaTest {

    public static void main(String[] args) {

        LambdaService1 service1 = () -> "a";

        LambdaService2 service2 = (Integer i) -> "alin" + i;
        LambdaService2 service21 = (Integer i) -> {
            return "alin" + i;
        };


        LambdaService2 service3 = (Integer i) -> "alin";

        LambdaService3 service31 = (String s) -> System.out.println("abcd");

        Runnable r1 = () -> {
        };

        process1((String s) -> System.out.println("" + s + ", ok"));
    }


    public static void process1(LambdaService3 service) {
        service.consume("sj");
    }
}
