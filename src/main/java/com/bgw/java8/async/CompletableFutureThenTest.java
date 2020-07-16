package com.bgw.java8.async;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFutureThenTest
 *
 * @author wang
 * @since 2020/7/16 23:41
 **/
public class CompletableFutureThenTest {

    public static void main(String[] args) {

        thenApply();

    }

    private static void thenApply() {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "f1");
        // r f1的运行结果
        CompletableFuture<String> f2 = f1.thenApply(r -> r + "-f2");

        System.out.println(f2.join());


    }
}
