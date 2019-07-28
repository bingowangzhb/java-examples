package com.juc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 说明：VolatileObjectTest
 *
 * @author ShujuboDev 2019/7/11 9:48
 */
public class VolatileObjectTest implements Runnable {
    private ObjectA a; // 加上volatile 就可以正常结束While循环了

    public VolatileObjectTest(ObjectA a) {
        this.a = a;
    }

    public ObjectA getA() {
        return a;
    }

    public void setA(ObjectA a) {
        this.a = a;
    }

    @Override
    public void run() {
        long i = 0;
        while (a.isFlag()) {
            i++;
        }
        System.out.println("stop My Thread " + i);
    }

    public void stop() {
        a.setFlag(false);
    }

    public static void main(String[] args) throws InterruptedException {
        // 如果启动的时候加上-server 参数则会 输出 Java HotSpot(TM) Server VM
        System.out.println(System.getProperty("java.vm.name"));

        VolatileObjectTest test = new VolatileObjectTest(new ObjectA());
        new Thread(test).start();

        Thread.sleep(1000);
        test.stop();
        Thread.sleep(1000);
        test.wait();
        System.out.println("Main Thread " + test.getA().isFlag());
    }

    static class ObjectA {
        private volatile boolean flag = true;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

    }
}
