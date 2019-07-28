package com.juc.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 说明：ConditionTest
 *
 * @author ShujuboDev
 */
public class ConditionTest {

    public static void main(String[] args) {
        CountDownLatch c1 = new CountDownLatch(1);
        CountDownLatch c2 = new CountDownLatch(1);

        ExecutorService service = Executors.newFixedThreadPool(3);

        Thread threadB = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t 开始执行...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t 开始完毕...");
            }
            finally {
                c1.countDown();
            }
        }, "B");

        Thread threadC = new Thread(() -> {

            try {
                try {
                    c1.await();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t 开始执行...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t 开始完毕...");
            }
            finally {
                c2.countDown();
            }
        }, "C");

        Thread threadA = new Thread(() -> {
            try {
                c2.await();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 开始执行...");
            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 开始完毕...");
        }, "A");

//        threadA.start();
//        threadB.start();
//        threadC.start();
        service.submit(threadA);
        service.submit(threadB);
        service.submit(threadC);
    }
}
