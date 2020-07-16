package com.bgw.java8.practice.ch11;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CompletalbeFutureTestCase
 *
 * @author wang
 * @since 2020/7/6 21:58
 **/
public class CompletableFutureTestCase {

    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            int t = getRandom(5, 10);
            System.out.println("f1 t : " + t);
            sleep(t, TimeUnit.SECONDS);
            return String.valueOf(t);
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            int t = getRandom(5, 10);
            System.out.println("f2 t : " + t);
            sleep(t, TimeUnit.SECONDS);
            return String.valueOf(t);
        });

//        CompletableFuture<String> f3 = f1.applyToEither(f2, s -> s);
//        System.out.println(f3.join());
    }

    private static void sleep(int timeout, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int getRandom(int startInclusive, int endExclusive) {
        return RandomUtils.nextInt(startInclusive, endExclusive);
    }


    public static void test() {
        AtomicInteger total = new AtomicInteger();
        List<Long> testList = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            testList.add(Long.valueOf("200" + i));
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //每10次切分成一个list去请求
        List<List<Long>> allList = Lists.partition(testList, 10);
        Map<Long, Integer> authMap = new HashMap<>(testList.size());
        try {
            for (List<Long> partList : allList) {
                int size = partList.size();
                CompletableFuture<Map<Long, Integer>>[] arrays = new CompletableFuture[size];

                //10次异步请求
                for (int i = 0; i < partList.size(); i++) {
                    Long advertiserUid = partList.get(i);
                    CompletableFuture<Map<Long, Integer>> completableFuture = CompletableFuture.supplyAsync(() -> {
                        int n = getRandom(200, 300);
                        sleep(n, TimeUnit.MILLISECONDS);

                        Map<Long, Integer> map = new HashMap<>(1);
                       // map.put(advertiserUid, powerAuth());

                        total.addAndGet(n);
                        // log.info("异步thread id={},time cost={}ms", Thread.currentThread().getId(), n);
                        return map;
                    });

                    arrays[i] = completableFuture;
                }

                CompletableFuture.allOf(arrays).join();

                //获取10次异步结果
                for (CompletableFuture<Map<Long, Integer>> item : arrays) {
                    Map<Long, Integer> map = item.get();
                    for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                        authMap.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        } catch (Exception e) {
            // log.error("出错={}", e);
        }

        stopWatch.stop();

//        log.info("authMap={}", authMap);
//        log.info("同步耗时={}", total.get());
//        log.info("异步耗时={}", stopWatch.getTotalTimeMillis());
    }

//    public static Integer powerAuth() {
//        Integer n = RandomUtil.randomInt(200, 300);
//        return n;
//    }
}
