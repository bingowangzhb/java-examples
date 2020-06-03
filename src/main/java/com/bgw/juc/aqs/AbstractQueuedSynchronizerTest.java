package com.bgw.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 说明：AbstractQueuedSynchronizerTest
 *
 * @author ShujuboDev
 */
public class AbstractQueuedSynchronizerTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        ShareObj obj = new ShareObj(lock);

        new Thread(obj::add, "Thread-A").start();
        new Thread(obj::add, "Thread-B").start();
//        new Thread(obj::add, "Thread-C").start();
//        new Thread(obj::add, "Thread-D").start();
    }
}

class ShareObj {
    private Lock lock;

    private static volatile int i = 0;

    public ShareObj(Lock lock) {
        this.lock = lock;
    }

    public void add() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\t 获得锁");

        try {
            // codes
            System.out.println(Thread.currentThread().getName() + "\t 正在处理。。。");
            i++;
            try {
                TimeUnit.SECONDS.sleep(3);
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
