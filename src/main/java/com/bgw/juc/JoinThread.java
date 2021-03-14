package com.bgw.juc;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 说明：如果一个线程A执行了线程B.join()方法，那么当前线程A等待线程B终止之后才从join()返回
 *
 * @author ShujuboDev 2018/11/12 15:45
 */
public class JoinThread {


    public static void main(String[] args) {
        testThreadJoin();
    }

    private static void testThreadJoin() {
        Thread t = new Thread(() -> {
            System.out.println(" 我去买醋了 ");
            sleepTwoSeconds();
            System.out.println(" 醋买回来了 ");
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" 开始吃饺子 ");


    }




    private static void testThreadsJoin() {
        List<Thread> threads = IntStream.range(1, 3)
                .mapToObj(JoinThread::newThread)
                .collect(Collectors.toList());
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
            TimeUnit.SECONDS.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
