package com.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * 说明：SimpleBlockingQueue
 *
 * @author ShujuboDev
 */
public class SimpleBlockingQueue {

    public SimpleBlockingQueue(int size) {
        this.size = size;
    }

    /**
     * QUE_LEN
     */
    private int size = 10;

    /**
     * list
     */
    private List<String> list = new ArrayList<>();

    /**
     * lock
     */
    private final Object lock = new Object();
    // 1. 当队列为空，消费者线程不能消费，只能等待元素被放入
    // 2. 当队列满时，生产者线程不能生产，只能等待元素被取出

    /**
     * put
     * @param s s
     */
    public void put(String s) {
        synchronized (lock) {
            while (isFull()) {
                try {
                    System.out.println("队列已满, 线程" + currentThread().getName() + "进入等待状态");
                    lock.wait();


                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(s);
            lock.notify();
            System.out.println("队列大小：" + list.size() + ", 线程" + currentThread().getName() + " put " + s);
        }
    }

    public String get() {
        synchronized (lock) {
            while (list.isEmpty()) {
                try {
                    System.out.println("队列已空, 线程" + currentThread().getName() + " 进入等待状态");
                    lock.wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notify();
            System.out.println("队列大小：" + list.size() + ", 线程" + currentThread().getName() + " get " + list.get(0));
            return list.remove(0);
        }
    }


    /**
     * 队列是否满了
     * @return boolean
     */
    public boolean isFull () {
        synchronized (lock) {
            return list.size() == size;
        }
    }

    public static void main(String[] args) {
        final SimpleBlockingQueue queue = new SimpleBlockingQueue(10);

        for (int i = 0 ; i < 30; i++) {
            new Thread(() -> {
                queue.put(UUID.randomUUID().toString());
            }, "PUT-T-" + i).start();
            try {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            new Thread(() -> {
                queue.get();
            }, "GET-T-" + i).start();

            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0 ; i < 30; i++) {

        }
    }
}
