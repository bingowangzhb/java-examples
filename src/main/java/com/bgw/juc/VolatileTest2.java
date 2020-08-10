package com.bgw.juc;

import javafx.concurrent.Task;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * VolatileTest2
 *
 * @author wang
 * @since 2020/7/28 23:01
 **/
public class VolatileTest2 {





    public static void main(String[] args) {

        TaskInfo taskInfo = new TaskInfo();

        new Thread(taskInfo).start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //taskInfo.a.set(false);
        taskInfo.a = false;
        System.out.println("finish set a false");
    }



    static class TaskInfo implements Runnable {

        //AtomicBoolean a = new AtomicBoolean(true);
        boolean a = true;
        @Override
        public void run() {
            while (a) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("finish task");
        }
    }









}
