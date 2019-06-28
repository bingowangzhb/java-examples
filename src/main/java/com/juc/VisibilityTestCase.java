package com.juc;

import java.util.concurrent.TimeUnit;

/**
 * 说明：
 *
 * @author ShujuboDev
 */
public class VisibilityTestCase {


    static class VisibilityThread extends Thread {
        private boolean stop;

        @Override
        public void run() {
            int i = 0;
            System.out.println("start loop.");

            while (!getStop()) {
                i++;
            }
            System.out.println("finish loop, i = " + i);
        }

        public boolean getStop() {
            return stop;
        }

        public void setStop() {
            stop = true;
        }
    }


    public static void main(String[] args) {
        VisibilityThread v = new VisibilityThread();
        v.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("即将设置stop为true");
        v.setStop();
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finish set");
        System.out.println("main中通过getStop获取的stop值:" + v.getStop());
    }
}
