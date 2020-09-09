package com.bgw.thd;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.IntStream;

/**
 * ThreadStateTest2
 *
 * @author zhibin.wang
 * @since 2020/09/08 17:34
 */
public class ThreadStateTest2 {


    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        ShareObj shareObj = new ShareObj(lock);

        runWithFixedThreads(shareObj);
        //runWithMultipleThreads(shareObj);
    }

    private static void runWithMultipleThreads(ShareObj shareObj) {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            new Thread(() -> {
                shareObj.put();
            }, "T-P-" + i).start();
        });

        IntStream.rangeClosed(1, 10).forEach(i -> {
            new Thread(() -> {
                shareObj.get();
            }, "T-C-" + i).start();
        });
    }


    private static void runWithFixedThreads(ShareObj shareObj) {
        new Thread(() -> {
            IntStream.rangeClosed(1, 10).forEach(i -> {
                shareObj.get();
            });
        }, "A").start();

        new Thread(() -> {
            IntStream.rangeClosed(1, 20).forEach(i -> {
                shareObj.put();
            });
        }, "B").start();

        new Thread(() -> {
            IntStream.rangeClosed(1, 10).forEach(i -> {
                shareObj.get();
            });
        }, "C").start();
    }


}

class ShareObj {
    private final Object lock;
    private int count = 0;
    public ShareObj(Object lock) {
        this.lock = lock;
    }

    public void put() {
        synchronized (lock) {
            while (count != 0) {
                try {
                    // 锁什么对象就要用什么对象的wait，notify方法
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 模拟生产
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + ", " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:hh:ss")) + " after put:count=" + count);
            lock.notifyAll();
        }
    }

    public void get() {
        synchronized (lock) {
            while (count == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println(Thread.currentThread().getName() + ", " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:hh:ss")) + " after get:count=" + count);
            lock.notifyAll();
       }
    }
}