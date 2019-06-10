package com.juc;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/14 16:38
 */
public class VolatileFoo {

    final static int MAX = 5;
    static int initVal = 0;


    public static void main(String[] args) {
        new Thread(() -> {
            int localVal = initVal;
            while (localVal < MAX) {
                if (initVal != localVal) {
                    System.out.printf("the initVal is updated to [%d]\n", initVal);
                    localVal = initVal;
                }
            }


        }, "Reader").start();

        new Thread(() -> {
            int localVal = initVal;
            while (localVal < MAX) {
                System.out.printf("the initVal will be changed to [%d]\n", ++localVal);
                initVal = localVal;

                try {
                    TimeUnit.SECONDS.sleep(5);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "Updater").start();

    }


}
