package com.thd;

import java.util.concurrent.TimeUnit;

/**
 * 说明：VolatileTest
 *
 * @author ShujuboDev
 */
public class VolatileTest {
    private boolean flag = true;

    public void handle() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "\t handle is running");
            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        VolatileTest t = new VolatileTest();

        new Thread(() -> t.handle(), "A").start();

        try {
            TimeUnit.SECONDS.sleep(8);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {

            t.flag = false;
            System.out.println("设置flag=false");
        }).start();

        System.out.println("------------------");
    }
}
