package com.juc;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/10/31 10:55
 */
public class ObjectService {

    Object lock = new Object();

    private final static Object LOCK = new Object();

    public void serviceMethodA() {
        try {
            synchronized (lock) {
                System.out.println("A begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end   time=" + System.currentTimeMillis());
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB() {
        synchronized (LOCK) {
            System.out.println("B begin time=" + System.currentTimeMillis());

            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B end   time=" + System.currentTimeMillis());
        }
    }

    public synchronized void serviceMethodC() {
        System.out.println("C begin time=" + System.currentTimeMillis());

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("C end   time=" + System.currentTimeMillis());
    }


    public void serviceMethodD() {
        synchronized (ObjectService.class) {
            System.out.println("D begin time=" + System.currentTimeMillis());

            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("D end   time=" + System.currentTimeMillis());
        }
    }
}
