package com.bgw.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * ReentrantLockTest2
 *
 * @author zhibin.wang
 * @since 2021/03/18 10:38
 */
public class ReentrantLockTest2 {
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();

        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                System.out.println(getThdName() + " acquire lock");

                sleep(5);

            }
            finally {
                System.out.println(getThdName() + " release lock");
                lock.unlock();
            }
        }, "Thread-A");

        Thread threadB = new Thread(() -> {
            try {
                lock.lock();
            } catch (Exception e) {
                System.out.println(getThdName() + " 中断了");
                e.printStackTrace();
            }
            try {
                System.out.println(getThdName() + " acquire lock");

                sleep(5);

            }
            finally {
                System.out.println(getThdName() + " release lock");
                lock.unlock();
            }
        }, "Thread-B");

        Thread threadC = new Thread(() -> {
            lock.lock();
            try {
                System.out.println(getThdName() + " acquire lock");

                sleep(5);

            }
            finally {
                System.out.println(getThdName() + " release lock");
                lock.unlock();
            }
        }, "Thread-C");

        threadA.start();
        sleep(1);
        threadB.start();
        threadC.start();

        threadB.interrupt();


    }


    private static void sleep(long l) {
        try {
            TimeUnit.SECONDS.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static String getThdName() {
        return Thread.currentThread().getName();
    }

}
