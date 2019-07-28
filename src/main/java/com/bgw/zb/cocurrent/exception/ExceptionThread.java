package com.bgw.zb.cocurrent.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/8/23 14:55
 */
public class ExceptionThread implements Runnable {

    public void run() {
        throw new RuntimeException();
    }


    public static void main(String[] args) {
        try {
            ExecutorService excutorService = Executors.newCachedThreadPool();
            excutorService.execute(new ExceptionThread());
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(111);
        }
    }
}
