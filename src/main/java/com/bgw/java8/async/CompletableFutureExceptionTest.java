package com.bgw.java8.async;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFutureExceptionTest
 *
 * @author wang
 * @since 2020/7/16 23:45
 **/
public class CompletableFutureExceptionTest {

    public static void main(String[] args) {
        CompletableFuture<Integer> f0 = CompletableFuture.supplyAsync(() -> 7 / 0)
                .thenApply(r -> r * 10)
                .exceptionally(e -> 0);

        System.out.println(f0.join());
    }
}
