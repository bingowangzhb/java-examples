package com.bgw.java8.practice.ch11;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Shop
 *
 * @author wang
 * @since 2020/7/5 22:16
 **/
public class Shop {

    /**
     * showName
     */
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private final static Random RANDOM = new Random();
    public String getPrice(String product) {
        BigDecimal price = doCalculatePrice(product);
        Discount.Code code = Discount.Code.values()[RANDOM.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    private BigDecimal doCalculatePrice(String product) {
        delay();
        return BigDecimal.valueOf(RANDOM.nextDouble() * product.charAt(0) + product.charAt(1));
    }

    public Future<BigDecimal> getPriceAsync(String product) {
        CompletableFuture<BigDecimal> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            try {
                BigDecimal price = doCalculatePrice(product);
                completableFuture.complete(price);
            } catch (Exception e) {
                e.printStackTrace();
                completableFuture.completeExceptionally(new RuntimeException("product not available"));
            }
        }).start();

        return completableFuture;
    }

    public Future<BigDecimal> getPriceAsyncWithSupplier(String product) {
        return CompletableFuture.supplyAsync(() -> doCalculatePrice(product));
    }


    private void delay() {
        int randomTimeout = RANDOM.nextInt(3);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
