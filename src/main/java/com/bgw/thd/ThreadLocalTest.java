package com.bgw.thd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocalTest
 *
 * @author zhibin.wang
 * @since 2020/08/24 11:26
 */
public class ThreadLocalTest {


    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(100);
        FooService fooService = new FooService();
        for (int i = 0; i < 100; i++) {
            es.execute(fooService::business);
        }


    }


}



