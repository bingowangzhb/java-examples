package com.juc.lock;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/13 10:55
 */
public class BooleanLockTestCase {


    private final MyLock lock = new BooleanMyLock();


    public void syncMethod() {
        try {
            lock.lock();
            int randomInt = current().nextInt(10);
            System.out.println(randomInt);
            System.out.println(currentThread().getName() + "get the lock");

            TimeUnit.SECONDS.sleep(randomInt);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BooleanLockTestCase bltc = new BooleanLockTestCase();
        //IntStream.range(1, 6).mapToObj(i -> new Thread(bltc::syncMethod)).forEach(Thread::start);


        for (int i = 0; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    bltc.syncMethod();
                }
            }).start();
        }


    }

}
