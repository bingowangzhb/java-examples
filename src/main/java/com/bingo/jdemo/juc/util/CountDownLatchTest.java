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
                Random r = new Random();
                int time = r.nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(time);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t " + "准备好了");
                latch.countDown();
            }, i + "号选手").start();
        }

        try {
            latch.await();
            System.out.println("裁判准备发号施令枪");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
