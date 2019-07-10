package com.juc.util;

import java.util.concurrent.TimeUnit;

/**
 * 说明：JoinThreadTest
 *
 * @author ShujuboDev
 */
public class JoinThreadTest {
    public static void main(String[] args) {

        // B->C->A
        Thread threadB = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 开始执行...");
            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 开始完毕...");
        }, "B");

        Thread threadC = new Thread(() -> {
            try {
                threadB.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 开始执行...");
            try {
                TimeUnit.SECONDS.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 开始完毕...");
        }, "C");
        Thread threadA = new Thread(() -> {
            try {
                threadC.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 开始执行...");
            try {
                TimeUnit.SECONDS.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 开始完毕...");
        }, "A");

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
