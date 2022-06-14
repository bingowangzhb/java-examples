package com.bgw.java8.async;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFutureExceptionTest
 *
 * @author wang
 * @since 2020/7/16 23:45
 **/
@Slf4j
public class CompletableFutureExceptionTest {

    public static void main(String[] args) {
        // 创建完CompletableFuture对象之后，会自动地异步执行 runnable.run()方法或者supplier.get()方法
        CompletableFuture<Void> f0 = CompletableFuture.supplyAsync(() -> {
                    log.info("task:f0");

                    return 1;
                })
                .thenApplyAsync(r -> {
                    log.info("task:thenApplyAsync " + r);
                    return r * 10;
                })
                .thenAccept(r ->
                        log.info("task:thenAccept = " + r))
                .thenRun(() -> log.info("thenRun"))
                .exceptionally(e -> {
                    System.out.println("e = " + e);
                    return null;
                });
        f0.join();
        log.info("--------------------------");
    }
}
