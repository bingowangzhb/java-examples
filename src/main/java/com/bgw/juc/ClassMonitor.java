package com.bgw.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/12 16:56
 */
public class ClassMonitor {

    private static final Object lock = new Object();

    public static synchronized void methodA () {
        System.out.println(Thread.currentThread().getName() + ": mehtodA");


        try {
            TimeUnit.SECONDS.sleep(10);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    public static void methodB () {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + ": mehtodB");
            try {
                TimeUnit.SECONDS.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void methodC () {
        synchronized (ClassMonitor.class) {
            System.out.println(Thread.currentThread().getName() + ": mehtodC");
            try {
                TimeUnit.SECONDS.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new Thread(ClassMonitor::methodB, "B").start();
        new Thread(ClassMonitor::methodC, "C").start();

        ReentrantLock lock;
    }
}
