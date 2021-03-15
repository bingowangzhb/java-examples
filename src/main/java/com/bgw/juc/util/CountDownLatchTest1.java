package com.bgw.juc.util;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * CountDownLatchTest1
 *
 * @author wang
 * @since 2021/3/15 21:53
 **/
public class CountDownLatchTest1 {

    public static void main(String[] args) {
        // 3个游戏玩家
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 1; i < 4; i++) {
            new Thread(() -> {
                try {
                    // 模拟准备时间
                    int randomSecs = (int) (Math.random() * 10 + 1);
                    try {
                        TimeUnit.SECONDS.sleep(randomSecs);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "已准备好，耗时" + randomSecs + "s");
                }
                finally {
                    countDownLatch.countDown();
                }
            }, "player[" + i + "]").start();
        }

        System.out.println(" 等待所有玩家准备就绪 ");

        try {
            countDownLatch.await();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" 所有玩家都已准备就绪，开始游戏 ");
    }

}
