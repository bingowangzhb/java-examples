package com.juc.lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;

import static java.lang.Thread.currentThread;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/13 10:30
 */
public class BooleanMyLock implements MyLock {

    private Thread currentThread;
    private boolean locked = false;
    private final List<Thread> blockedList = new ArrayList<>();

    CountDownLatch countDownLatch;

    @Override
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (locked) {
                if (!blockedList.contains(currentThread())) {
                    blockedList.add(currentThread());
                }
                this.wait();
            }

            blockedList.remove(currentThread());
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {

    }

    @Override
    public void unlock() {
        synchronized (this) {
            if (this.currentThread == currentThread()) {
                this.locked = false;
                Optional.of(currentThread().getName() + "release the lock").ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(this.blockedList);
    }
}
