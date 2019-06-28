package com.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 说明：LockTest
 *
 * @author ShujuboDev
 */
public class LockTest {

    public static void main(String[] args) {
        ShareObj obj = new ShareObj();



        new Thread(() -> obj.add(), "A").start();
        new Thread(() -> obj.add(), "B").start();
        new Thread(() -> obj.add(), "C").start();
        new Thread(() -> obj.add(), "D").start();
//        new Thread(() -> obj.add(), "E").start();

//        for (int i = 1; i <= 20; i++) {
//            new Thread(() -> {
//                obj.add();
//            }, "Thread-" + i).start();
//        }
    }
}

class ShareObj {
    private Lock lock = new ReentrantLock();

    static volatile int i = 0;

    public void add() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\t 获得锁");

        try {
            // codes
            System.out.println(Thread.currentThread().getName() + "\t 正在处理。。。");
            i++;
            try {
                TimeUnit.SECONDS.sleep(3000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "\t 释放锁");
        }
    }
}
