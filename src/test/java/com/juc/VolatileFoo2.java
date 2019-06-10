package com.juc;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/15 9:56
 */
public class VolatileFoo2 {

    static int a = 0;
    static volatile boolean flag = false;

    private static void write() {
        a = 2;              //1
        flag = true;        //2
    }

    private static void multiply() {
        System.out.println(flag);
        System.out.println(a);
        if (flag) {         //3
            int ret = a * a;//4
            System.out.println(ret);

        }
    }


    public static void main(String[] args) throws InterruptedException {


//        new Thread(() -> {
//            while (true) {
//                System.out.println(currentThread().getName() + " a : " + a);
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                }
//                catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if (a == 10) {
//                    System.out.println("aaaaa");
//                }
//            }
//        }).start();







        new Thread(() -> {
            while (true) {
                if (a < 10) {
                    a++;

                    System.out.println(currentThread().getName() + " a : " + a);
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    break;
                }
            }
        }).start();


        while (true) {
            System.out.println(currentThread().getName() + " a : " + a);
            try {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (a == 10) {
                System.out.println("aaaaa");
            }
        }
    }

}
