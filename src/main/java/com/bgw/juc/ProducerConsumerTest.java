package com.bgw.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * ProducerConsumerTest
 *
 * @author zhibin.wang
 * @since 2020/09/09 13:16
 */
public class ProducerConsumerTest {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        ShareResource sr = new ShareResource(lock);


        IntStream.rangeClosed(1, 20).forEach(i -> {
            new Thread(() -> {
                sr.produce();
            }, "T-P-" + i).start();
        });

        IntStream.rangeClosed(1, 10).forEach(i -> {
            new Thread(() -> {
                sr.consume();
            }, "T-C-" + i).start();
        });

        IntStream.rangeClosed(11, 20).forEach(i -> {
            new Thread(() -> {
                sr.consume();
            }, "T-C-" + i).start();
        });
    }


    public static void runWithLockSupport() {

    }

}

class ShareResource {
    private int count = 0;
    private final Lock lock;
    private final Condition canConsumeCondition;
    private final Condition canProduceCondition;

    public ShareResource(Lock lock) {
        this.lock = lock;
        this.canConsumeCondition = lock.newCondition();
        this.canProduceCondition = lock.newCondition();
    }

    public void produce () {
        Thread currentThread = Thread.currentThread();
        lock.lock();
        try {
            while (count == 1) {
                try {
                    this.canProduceCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count++;
            System.out.println(currentThread.getName() + " after : count=" + count);

            this.canConsumeCondition.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public void consume() {

        Thread currentThread = Thread.currentThread();
        lock.lock();
        try {
            while (count == 0) {
                try {
                    this.canConsumeCondition.await();
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

            System.out.println(currentThread.getName() + " after : count=" + count);
            this.canProduceCondition.signalAll();
        }
        finally {
            lock.unlock();
        }

    }

}


