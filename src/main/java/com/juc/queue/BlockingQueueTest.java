package com.juc.queue;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 说明：BlockingQueueTest
 *
 * @author ShujuboDev
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);
        List<String> list = new ArrayList<>();

        AbstractQueuedSynchronizer synchronizer;
        ReentrantLock lock;

        AtomicInteger atomicInteger;

    }
}
