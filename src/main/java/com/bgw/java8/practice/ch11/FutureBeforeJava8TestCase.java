package com.bgw.java8.practice.ch11;

import java.util.Random;
import java.util.concurrent.*;

/**
 * FutureBeforeJava8TestCase
 *
 * @author wang
 * @since 2020/7/5 21:35
 **/
public class FutureBeforeJava8TestCase {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(FutureBeforeJava8TestCase::doSomeLongComputation);
        doSomethingElse();

        try {
            future.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {

            // ExecutionException 计算异常

            // InterruptedException 该线程在等待过程中被中断

            // TimeoutException 在Future对象完成之前超过已过期

            ex.printStackTrace();
        }

        executorService.shutdown();
    }

    private static void doSomethingElse() {
        System.out.println("do something else ....");
    }

    private static String doSomeLongComputation() {

        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finish computation...");

        return "success";
    }
}
