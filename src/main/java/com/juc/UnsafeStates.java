package com.juc;

import java.util.concurrent.BlockingQueue;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/6 14:14
 */
public class UnsafeStates {

    private String[] states = new String[]{"AK", "AL"};

    public String[] getStates() {
        return states;
    }


    public static void main(String[] args) {
//        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
//
//        Producer producer = new Producer(blockingQueue);
//        Consumer consumer = new Consumer(blockingQueue);
//
//        Printer printer = new Printer(blockingQueue);
//        new Thread(printer).start();
//
//        new Thread(producer).start();
//       // new Thread(consumer).start();
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(123);
//            }
//        }).start();
//
//        new Thread(() -> {
//            System.out.println(123);
//            //LambdaExpression
//
//        }).start();

        //IntStream.range(1, 8).mapToObj(e -> "a" + e).forEach(System.out::println);

    }


    static class Printer implements Runnable {
        private BlockingQueue<String> blockingQueue;

        public Printer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }


        @Override
        public void run() {
            for (;;){
                System.out.println(blockingQueue.size());
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class Producer implements Runnable {
        private BlockingQueue<String> blockingQueue;
        public Producer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            for(;;) {
                blockingQueue.add("1");

                try {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue<String> blockingQueue;

        public Consumer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            for(;;){
                try {
                    System.out.println("" + blockingQueue.take());
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
