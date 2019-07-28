package com.juc.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 说明：DeadLockTest
 *
 * @author ShujuboDev
 */
public class DeadLockTest {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        ShareObject shareObject = new ShareObject(lockA, lockB);

        new Thread(() -> {
            shareObject.m1();
        }, "A").start();new Thread(() -> {
            shareObject.m2();
        }, "B").start();

    }

    static class ShareObject {
        private String lockA;
        private String lockB;

        public ShareObject(String lockA, String lockB) {
            this.lockA = lockA;
            this.lockB = lockB;
        }

        public void m1() {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "\t m1");
                m2();
            }
        }

        public void m2() {
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t m2");
                m1();
            }
        }
    }

    // AbstractQueuedSynchronizer
}
