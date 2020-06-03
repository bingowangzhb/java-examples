package com.bgw.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 说明：VolatileTest
 *
 * @author ShujuboDev
 */
public class VolatileTest {
    private static Map<String, String> CACHE = new HashMap<>();
    private static volatile int[] nums = new int[5];

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            nums[2] = 4;
            CACHE.put("a", "a");
        }).start();

        System.out.println("aaaaaaaaaaaaaaa");
        while (nums[2] != 4) {

        }

        System.out.println("abc");
    }
}
