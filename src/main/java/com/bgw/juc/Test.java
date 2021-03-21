package com.bgw.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Test
 *
 * @author wang
 * @since 2021/3/20 12:13
 **/
public class Test {

    public static void main(String[] args) throws InterruptedException {
        ValueObj obj = new ValueObj();

        new Thread(() -> {
            obj.opt();
        }, "A").start();

        Thread willBeInterruptedThd = new Thread(() -> {
            if (!obj.tryLock()) {
                boolean p = obj.shouldPark();
                System.out.println("p = " + p);
            }
        }, "B");

        willBeInterruptedThd.start();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("willBeInterruptedThd.getState() = " + willBeInterruptedThd.getState());
        willBeInterruptedThd.interrupt();

        System.out.println("willBeInterruptedThd.getState() = " + willBeInterruptedThd.getState());
    }




}

class ValueObj {

    private Lock lock = new ReentrantLock();
    public boolean shouldPark() {
        LockSupport.park(this);
        System.out.println(" abc ");
        return Thread.interrupted();
    }

    public void opt() {
        lock.lock();
        try {
            // do sth
            try {
                TimeUnit.SECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        finally {
            lock.unlock();
        }
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

}
