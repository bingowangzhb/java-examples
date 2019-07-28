package com.juc.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 说明：JoinCountDownLatchTest
 *
 * @author ShujuboDev
 */
public class JoinCountDownLatchTest {
    // 创建一个CountDown Latch 实例
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main (String[] args) throws InterruptedException {
        Thread oneThread = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                countDownLatch.countDown();
            }

            System.out.println("oneThread is over!");
        });

        Thread twoThread = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                countDownLatch.countDown();
            }

            System.out.println("twoThread is over!");
        });

        oneThread.start();
        twoThread.start();

        System.out.println("main thread wait two child threads over....");
        countDownLatch.await();
        System.out.println("all child threads over!!!");
    }
}
