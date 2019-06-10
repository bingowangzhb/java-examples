package com.juc;

/**
 * 说明：DoubleCheckTest
 *
 * @author ShujuboDev
 */
public class DoubleCheck {
    private static DoubleCheck instance;

    private DoubleCheck() {
    }

    public static DoubleCheck getInstance() {
        //第一次检测
        if (instance == null) {
            //同步
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    //多线程环境下可能会出现问题的地方
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new ObjectCreatorThread1().start();
        }

        for (int i = 0; i < 100000; i++) {
            new ObjectCreatorThread2().start();
        }
    }
}

class ObjectCreatorThread1 extends Thread {
    @Override
    public void run() {
        System.out.println(DoubleCheck.getInstance().hashCode());
    }
}
class ObjectCreatorThread2 extends Thread {
    @Override
    public void run() {
        System.out.println(DoubleCheck.getInstance().hashCode());
    }
}