package com.thd;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 说明：TheadStateTest 线程状态
 *
 * @author ShujuboDev
 */
public class ThreadStateTest {

    static class ShareResource {
        public void testBlocked() {
            synchronized (this) {
                while(true) {

                }
            }
        }
    }

    /**
     * main
     * @param args args
     */
    public static void main(String[] args) {

        ShareResource resource = new ShareResource();

        new Thread(() -> {
            while (true) {
            }
        }, "RunnableThread").start();

        new Thread(resource::testBlocked, "BlockedThread1").start();
        new Thread(resource::testBlocked, "BlockedThread2").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "TimedWaitedThread").start();

        LockSupport.park();
    }
}
