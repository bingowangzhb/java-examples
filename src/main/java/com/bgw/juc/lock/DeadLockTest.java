package com.bgw.juc.lock;

import java.util.stream.IntStream;

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

        System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
        // 10000000万个数  用线程来取 每个模拟处理100ms
        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                while (true) {}
            }, "T-" + i).start();
        }

        //new Thread(shareObject::m1, "A").start();

        //new Thread(shareObject::m2, "B").start();

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
