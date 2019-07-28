package com.bingo.jdemo.thd;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 说明：VolatileTest
 *
 * @author ShujuboDev
 */
public class VolatileTest {
    public static void main(String[] args) {

        FutureTask futureTask;

        MyData t = new MyData();
        new Thread(() -> {
            int i = 0;
            while (t.flag) {
                i++;
                byte[] b = new byte[1024];
                // 1. synchronized (MyData.class) {}

                // 2. System.out.println(1);

                // 3. try {
                //    TimeUnit.SECONDS.sleep(1);
                // } catch (InterruptedException e) {
                //    e.printStackTrace();
                // }
            }
            System.out.println(Thread.currentThread().getName() + "\t 2");
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.flag = false;

        System.out.println("aaaaaaaaaaaaaaaaaaaaa");
    }


}

class MyData {
    boolean flag = true;
}
