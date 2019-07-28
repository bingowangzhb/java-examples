package com.bgw.juc;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/6 9:55
 */
public class NoVisibilityTestCase {
    private static boolean ready;
    private static int number;

    private static class ReadThread extends Thread {


        @Override
        public void run() {
            while(!ready){
                System.out.println(number);
            }

            System.out.println(number);
        }
    }

    private static class WriteThread extends Thread {


        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            number = 42;
            ready = true;
        }
    }


    public static void main(String[] args) throws Exception {
        new ReadThread().start();
        new WriteThread().start();
    }


}
