package com.juc;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/12 15:45
 */
public class JoinThread {


    public static void main(String[] args) {
        List<Thread> threads = IntStream.range(1, 3).mapToObj(JoinThread::newThread).collect(Collectors.toList());
        threads.forEach(Thread::start);


        for (Thread thread : threads){
            try {
                thread.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "#" + i);
            sleepTwoSeconds();
        }
    }


    private static Thread newThread(int seq) {
        System.out.println(seq);
        return new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + "#" + i);
                sleepTwoSeconds();
            }
        });
    }


    private static void sleepTwoSeconds() {
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
