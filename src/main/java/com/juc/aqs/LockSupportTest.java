package com.juc.aqs;

import java.util.concurrent.locks.LockSupport;

/**
 * 说明：LockSupportTest
 *
 * @author ShujuboDev
 */
public class LockSupportTest {
    public static void main(String[] args) {

        System.out.println("begin park");
        LockSupport.park();
        System.out.println("finish park");

        Thread t;
    }
}
