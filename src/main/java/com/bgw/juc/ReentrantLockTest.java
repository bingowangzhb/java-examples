package com.bgw.juc;

import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 说明：ReentrantLockTest
 *
 * @author ShujuboDev
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        LongAdder adder;
        try {
            lock.lock();
            //
        }
        finally {
            lock.unlock();
        }
    }
}
