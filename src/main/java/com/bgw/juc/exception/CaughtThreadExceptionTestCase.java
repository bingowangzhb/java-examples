package com.bgw.juc.exception;

import java.util.concurrent.TimeUnit;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/13 11:38
 */
public class CaughtThreadExceptionTestCase {


    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println(t.getName() + " throw excepiton: " + e);
            e.printStackTrace();
        });


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println(1 / 0);

        }).start();

        ThreadGroup tg;
    }
}
