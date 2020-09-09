package com.bgw.thd;

import java.util.concurrent.TimeUnit;

/**
 * 说明：TheadStateTest 线程状态
 *
 * @author ShujuboDev
 */
public class ThreadStateTest {

    private static Object LOCK = new Object();

    public static void main(String[] args) {

        // threadState1();

        // threadState2();

        Thread t = new Thread(() -> {
            System.out.println("ThreadState: = " + Thread.currentThread().getState().toString());
            SleepUtils.sleep(3000);
            System.out.println("ThreadState: = " + Thread.currentThread().getState().toString());

            synchronized (LOCK) {
                System.out.println("ThreadState: = " + Thread.currentThread().getState().toString());
            }

        });
        System.out.println("ThreadState: = " + t.getState().toString());
        t.start();
        SleepUtils.sleep(10);
        System.out.println("ThreadState: = " + t.getState().toString());

        synchronized (LOCK) {
            SleepUtils.sleep(3000);
            System.out.println("ThreadState: = " + t.getState().toString());
        }

        SleepUtils.sleep(3000);
        System.out.println("ThreadState: = " + t.getState().toString());
    }

    /**
     * Thread.State: NEW -> RUNNABLE -> TIMED_WAITING -> RUNNING -> TERMINATED
     */
    private static void threadState2() {
        Thread t = new Thread(() -> {
            SleepUtils.sleep(200);
            System.out.println("t.state:" + Thread.currentThread().getState().toString());
        });
        System.out.println("t.state:" + t.getState().toString());
        t.start();
        System.out.println("t.state:" + t.getState().toString());
        SleepUtils.sleep(100);
        System.out.println("t.state:" + t.getState().toString());
        SleepUtils.sleep(100);
        System.out.println("t.state:" + t.getState().toString());
    }

    /**
     * Thread.State: NEW -> RUNNABLE -> TERMINATED
     */
    private static void threadState1() {
        Thread t = new Thread(() -> {
            System.out.println("CurrentThreadState: " + Thread.currentThread().getState().toString());
        });
        System.out.println("threadState = " + t.getState().toString());
        t.start();
        System.out.println("threadState = " + t.getState().toString());
        SleepUtils.sleep(50);
        System.out.println("threadState = " + t.getState().toString());
    }


    private class Lock {

    }
}
