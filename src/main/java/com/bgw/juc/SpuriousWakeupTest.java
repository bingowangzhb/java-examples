package com.bgw.juc;

/**
 * 说明：SpuriousWakeupsTest
 *
 * @author ShujuboDev
 */
public class SpuriousWakeupTest {

    public static void main(String[] args) {
        final Store store = new Store();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                store.put();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                store.put();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                store.get();
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                store.get();
            }
        }, "D").start();
    }
}

class Store {
    private int num = 0;

    public synchronized void put() {
        // 如果为if 会存在虚假唤醒
        while (num != 0) {
            System.out.println("库存已满 线程" + Thread.currentThread().getName() + "被阻塞");
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println(Thread.currentThread().getName() + "\t 被唤醒 生产 num : " + (++num));
        this.notifyAll();
    }

    public synchronized void get() {
        // 如果为if 会存在虚假唤醒
        while (num == 0) {
            System.out.println("库存不足 线程" + Thread.currentThread().getName() + "被阻塞");
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(Thread.currentThread().getName() + "\t 被唤醒 消费 num : " + (--num));
        this.notifyAll();
    }
}