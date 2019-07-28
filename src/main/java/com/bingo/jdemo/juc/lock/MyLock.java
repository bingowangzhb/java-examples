package com.bingo.jdemo.juc.lock;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/13 10:28
 */
public interface MyLock {
    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockedThreads();
}
