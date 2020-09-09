package com.bgw.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupportTest
 *
 * @author zhibin.wang
 * @since 2020/09/09 15:44
 */
public class LockSupportTest {

    public static void main(String[] args) {

        Thread mainThd = Thread.currentThread();
        System.out.println("MainThread State:" + mainThd.getState().toString());
        new Thread(() -> {

            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("MainThread State:" + mainThd.getState().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // LockSupport.unpark(mainThd);
            System.out.println("MainThread State:" + mainThd.getState().toString());
        }).start();

        LockSupport.parkUntil(10000);
    }
}
