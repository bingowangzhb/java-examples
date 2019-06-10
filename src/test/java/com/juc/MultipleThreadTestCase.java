package com.juc;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/10/31 10:56
 */


public class MultipleThreadTestCase {


    public static void main(String[] args) {
        ObjectService objectService = new ObjectService();

        MyThreadB threadB = new MyThreadB(objectService);
        threadB.setName("b");
        threadB.start();

        MyThreadA threadA = new MyThreadA(objectService);
        threadA.setName("a");
        threadA.start();

//        MyThreadC threadC = new MyThreadC(objectService);
//        threadC.setName("c");
//        threadC.start();

//        MyThreadD threadD = new MyThreadD(objectService);
//        threadD.setName("d");
//        threadD.start();


        

        //objectService.serviceMethodB();
    }





















    static class MyThreadA extends Thread {
        private ObjectService objectService;

        public MyThreadA(ObjectService objectService) {
            super();
            this.objectService = objectService;
        }

        @Override
        public void run() {
            super.run();
            objectService.serviceMethodA();
        }
    }

    static class MyThreadB extends Thread {
        private ObjectService objectService;

        public MyThreadB(ObjectService objectService) {
            super();
            this.objectService = objectService;
        }

        @Override
        public void run() {
            super.run();
            objectService.serviceMethodB();
        }
    }

    static class MyThreadC extends Thread {
        private ObjectService objectService;

        public MyThreadC(ObjectService objectService) {
            super();
            this.objectService = objectService;
        }

        @Override
        public void run() {
            super.run();
            objectService.serviceMethodC();
        }
    }

    static class MyThreadD extends Thread {
        private ObjectService objectService;

        public MyThreadD(ObjectService objectService) {
            super();
            this.objectService = objectService;
        }

        @Override
        public void run() {
            super.run();
            objectService.serviceMethodD();
        }
    }

}
