package com.bgw.java8.async;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Example01 {

    public static void main(String[] args) {

        CompletableFuture<Void> f1 = CompletableFuture.supplyAsync(() -> {
            log.info("f1");
            log.info(Thread.currentThread().getName());
            return "task-f1";
        }).thenApply(t -> {
            log.info(t);
            log.info(Thread.currentThread().getName());
            return null;
        });

//        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
//            log.info("f2");
//        }).thenRun(() -> {
//            log.info("qq");
//        });


        //CompletableFuture.allOf(f1, f2).join();

        log.info("abc");
    }

}
