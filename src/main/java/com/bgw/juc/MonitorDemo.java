package com.bgw.juc;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * 说明：MonitorDemo
 *
 * @author ShujuboDev
 */
public class MonitorDemo {

    public synchronized void run1() {
        System.out.println(currentThread().getName() + "获取锁 进入run1()");
        System.out.println(currentThread().getName() + "将等待500秒钟");
        try {
            TimeUnit.SECONDS.sleep(30); // sleep方法使得当前线程不会释放锁

            this.wait(); // 当前线程释放锁，进入WAITING状态
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(currentThread().getName() + "离开run1..., 唤醒其他线程");

    }

    public synchronized void run2() {
        System.out.println(currentThread().getName() + "获取锁 进入run2()");
        System.out.println(currentThread().getName() + "将等待50秒钟");
        try {
            TimeUnit.SECONDS.sleep(30); // sleep方法使得当前线程不会释放锁

            //this.wait(); // 当前线程释放锁，进入WAITING状态
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(currentThread().getName() + "离开run2... 唤醒其他线程");
        this.notify();
    }

    public synchronized void run3() {
        System.out.println(currentThread().getName() + "获取锁 进入run3()");
        System.out.println(currentThread().getName() + "将等待30秒钟");
        try {
            TimeUnit.SECONDS.sleep(30); // sleep方法使得当前线程不会释放锁

            //this.wait(); // 当前线程释放锁，进入WAITING状态
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(currentThread().getName() + "离开run3...");

    }


    public static void main(String[] args) throws Exception {
        final MonitorDemo demo = new MonitorDemo();

        new Thread(demo::run1, "T1").start();
        new Thread(demo::run2, "T2").start();
        new Thread(demo::run3, "T3").start();
    }
}
