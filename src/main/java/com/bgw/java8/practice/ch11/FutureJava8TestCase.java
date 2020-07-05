package com.bgw.java8.practice.ch11;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * FutureJava8TestCase
 *
 * @author wang
 * @since 2020/7/5 22:16
 **/
public class FutureJava8TestCase {




    static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("MyFavoriteShop"),
            new Shop("MyFavoriteShop"),
            new Shop("MyFavoriteShop"),
            new Shop("MyFavoriteShop"),
            new Shop("MyFavoriteShop"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("ShopEasy"));

    static final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        // doUseAsyncApiDemo();

        getPrices();
    }

    private static void getPrices() {
        long start = System.nanoTime();
        //List<String> prices = findPrices("myIPhone27S");
        List<String> prices = findPricesAsync("myIPhone27S");
        System.out.println(prices);
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println("Done in " + duration + " msecs");
    }

    private static List<String> findPrices(String product) {
        return shops.stream()
                .map(s -> s.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    private static List<String> findPricesAsync(String product) {
        List<CompletableFuture<String>> futurePrices = shops.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> s.getPrice(product), executor))
                .map(f -> f.thenApply(Quote::parse))
                .map(f -> f.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                .collect(Collectors.toList());

        return futurePrices.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }





    private static void doUseAsyncApiDemo() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<BigDecimal> futurePrice = shop.getPriceAsync("BestShop");
        long invocationTime = (System.nanoTime() - start) / 1000000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        doSomethingElse();

        try {
            BigDecimal price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException("get price exception");
        }

        long retrievalTime = (System.nanoTime() - start) / 1000000;
        System.out.println("price returned after " + retrievalTime + " msecs");
    }

    private static void doSomethingElse() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("do something else....");
    }
}
