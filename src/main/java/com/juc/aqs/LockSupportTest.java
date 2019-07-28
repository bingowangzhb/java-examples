package com.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 说明：LockSupportTest
 *
 * @author ShujuboDev
 */
public class LockSupportTest {
    private static final Object lock = new Object();

    public static void main(String[] args) throws Exception {

        Thread mainThread = Thread.currentThread();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                // LockSupport.unpark(mainThread);
                mainThread.interrupt();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        mainThread.join();
        System.out.println(Thread.currentThread().getName() + " \t begin park...");
        LockSupport.park();
        System.out.println(Thread.currentThread().getName() + "\t continue...");
    }
}
