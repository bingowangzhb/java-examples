package com.bgw.juc;

/**
 * 说明：SpuriousWakeupsTest
 *
 * @author ShujuboDev
 */
public class SpuriousWakeupsTest {

    public static void main(String[] args) {
        final Store store = new Store();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                store.put();
            }
        }, "Producer").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
//                try {
//                    Thread.sleep(200);//放大问题
//                }
//                catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                store.get();
            }
        }, "Consumer").start();
    }
}

class Store {
    // 总库存
    public static final int TOTAL = 1;
    // 现有
    private int num = 0;

    public synchronized void put() {
        while (num >= TOTAL) {
            System.out.println("库存已满");
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println(Thread.currentThread().getName() + "\t num : " + (++num));
        this.notifyAll();
    }

    public synchronized void get() {
        while (num <= 0) {
            System.out.println("库存不足");
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(Thread.currentThread().getName() + "\t num : " + (--num));
        this.notifyAll();
    }
}