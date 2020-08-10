package com.bgw.juc;

import java.util.concurrent.TimeUnit;

/**
 * VolatileTest3
 *
 * @author wang
 * @since 2020/7/28 23:29
 **/
public class VolatileTest3 {

    static class VolatileExample {
        int x = 0;
        volatile boolean v = false;

        public void writer() {
            x = 42;
            v = true;
        }

        public void reader() {
            if (v == true) {

            }
        }
    }


    public static void main(String[] args) {
        VolatileExample volatileExample = new VolatileExample();

        volatileExample.writer();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(volatileExample::reader).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}