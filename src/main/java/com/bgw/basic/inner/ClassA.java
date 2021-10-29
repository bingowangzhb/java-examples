package com.bgw.basic.inner;

/**
 * ClassA
 *
 * @author zhibin.wang
 * @since 2019-11-19 16:14
 **/
public class ClassA {

    public void doSomething(int k) {
        ClassB b1 = new ClassB() {
            public void doSomething() {
                System.out.println("b1.doSth");
            }

            @Override
            public void b() {
                System.out.println("a.c");
            }
        };

        b1.b();
        ClassC c1 = new ClassC() {
            void doSomething() {
                System.out.println("c1.doSth");
            }
        };
        ClassB b = new ClassB();
        b.b();
        ClassC c = new ClassC();
        c.c();
    }

    public class ClassB {
        public void b() {
            System.out.println("b");
        }
    }

    public class ClassC {
        public void c() {
            System.out.println("c");
            ClassB b = new ClassB() {};
        }
    }
}
