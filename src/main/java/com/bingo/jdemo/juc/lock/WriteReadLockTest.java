package com.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {
    /**
     * cache
     */
    private volatile Map<String, Object> cache = new HashMap<>();

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    /**
     * put
     *
     * @param key key
     * @param value value
     */
    public void put(String key, Object value) {
        // codes
        try {
            lock.writeLock().lock();
            // codes
            System.out.println(Thread.currentThread().getName() + "\t 放入key: " + key);
            cache.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 放入完成");
        }
        finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * get
     *
     * @param key key
     */
    public void get(String key) {
        try {
            lock.readLock().lock();
            // codes
            System.out.println(Thread.currentThread().getName() + "\t 取出：key: " + key + ": " + cache.get(key));
        }
        finally {
            lock.readLock().unlock();
        }
    }
}


/**
 * 说明：WriteReadLockTest
 *
 * @author ShujuboDev
 */
public class WriteReadLockTest {
    public static void main(String[] args) {
        MyCache cache = new MyCache();

        for (int i = 1; i <= 10; i++) {
            final int tmt = i;
            new Thread(() -> {
                cache.put("" + tmt, "" + tmt);
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 10; i++) {
            final int tmt = i;
            new Thread(() -> {
                cache.get("" + tmt);
            }, String.valueOf(i)).start();
        }
    }
}
