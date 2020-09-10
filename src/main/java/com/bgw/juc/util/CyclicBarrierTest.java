package com.bgw.juc.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrierTest
 *
 * @author zhibin.wang
 * @since 2020/09/10 16:08
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println(Thread.currentThread().getName() + ": 集齐七颗龙珠，召唤神龙");
        });

        for (int i = 1; i < 8; i++) {
            final int k = i;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t 集齐龙珠" + k);
                try {
                    int index = cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " await = " + index);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "Thread-" + i).start();
        }



    }
}
