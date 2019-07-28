package com.bgw.juc;

import java.util.concurrent.TimeUnit;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/12 14:41
 */
public class InterruptThread {

    public static void main(String[] args) {

//        Thread thread = new Thread(() -> {
//            while (true) {
//                // dosth
//                System.out.println("w");
//            }
//        });
//
//        thread.start();
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println("1 : " + thread.isInterrupted());
//        thread.interrupt();
//        System.out.println("2 : " + thread.isInterrupted());


//        Thread t = new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(20);
//            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//                System.out.println("sssssssssss");
//            }
//        });
//        t.start();
//        TimeUnit.SECONDS.sleep(10);
//        t.interrupt();

        System.out.println("1 : " + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("2 : " + Thread.currentThread().isInterrupted());


        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("3");
            //
            System.out.println("4 : " + Thread.currentThread().isInterrupted());
        }

    }


}
