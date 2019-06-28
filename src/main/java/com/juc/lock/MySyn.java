package com.juc.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 说明：MySyn
 *
 * @author ShujuboDev 2019/6/27 16:51
 */
public class MySyn extends AbstractQueuedSynchronizer {

    public static void main(String[] args) {
        MySyn syn = new MySyn();
        System.out.println(syn);
    }
}
