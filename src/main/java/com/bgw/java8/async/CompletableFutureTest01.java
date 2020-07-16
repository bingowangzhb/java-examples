package com.bgw.java8.async;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFutureTest01
 *
 * @author wang
 * @since 2020/7/16 21:20
 **/
public class CompletableFutureTest01 {


    public static void main(String[] args) {
        //任务1：洗水壶->烧开水
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println(getThreadName() + " T1:洗水壶...start");
            sleep(1);
            System.out.println(getThreadName() + " T1:洗水壶...end");
        });

        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
            System.out.println(getThreadName() + " T2:烧开水...start");
            sleep(10);
            System.out.println(getThreadName() + " T2:烧开水...end");
        });

        //
        CompletableFuture<String> f3 = f1.thenApply(r -> {
            System.out.println(getThreadName() + " r1=" + r);
            return "hh";
        }).thenCompose(r -> {
            System.out.println(getThreadName() + " r2=" + r);
            return CompletableFuture.supplyAsync(() -> "1");
        });
        System.out.println(f3.join());

        // 消费
        //CompletableFuture<Void> f4 = f3.thenAccept(r -> System.out.println(r));

//        CompletableFuture<Void> f5 = f3.thenRun(() -> {
//            System.out.println(1);
//        });




//        CompletableFuture<Void> f3 = CompletableFuture.runAsync(() -> {
//            System.out.println(getThreadName() + " T3:洗茶壶...start");
//            sleep(1);
//            System.out.println(getThreadName() + " T3:洗茶壶...end");
//        });


//        CompletableFuture<String> f6 = f1.thenCombine(f2, (r1, r2) -> {
//            System.out.println("泡茶喝");
//            return "helloWorld";
//        });

        // System.out.println(f6.join());
    }


    public static void sleep(int secs) {
        try {
            TimeUnit.SECONDS.sleep(secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static String getThreadName() {
        return Thread.currentThread().getName();
    }

    public static void printCurrentThread() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void print() {
        System.out.println("i am invoked...");
    }

}

interface Test {
    void test();
}
