package com.juc.util;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 说明：CountDownLatchTest
 *
 * @author ShujuboDev
 */
public class CountDownLatchTest {


    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                // codes
                try {
                    Random r = new Random();
                    int time = r.nextInt(10);
                    try {
                        TimeUnit.SECONDS.sleep(time);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t " + "到达了终点...");

                }
                finally {
                    latch.countDown();
                }
            }, i + "号选手").start();
        }

        try {
            latch.await();
            System.out.println("比赛结束...");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
