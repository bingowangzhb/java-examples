package com.bgw.jvm;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JavaStackTest {
    public static void main(String[] args) {
        JavaStackTest javaStackTest = new JavaStackTest();
        javaStackTest.increment(3);
        EventLoopGroup group = new NioEventLoopGroup();


        Lock lock = new ReentrantLock();
    }

    public void increment(int counter) {
        counter = counter + 3;
    }
}
