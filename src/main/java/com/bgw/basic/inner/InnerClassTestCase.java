package com.bgw.basic.inner;

/**
 * InnerClassTestCase
 *
 * @author zhibin.wang
 * @since 2019-11-19 16:49
 **/
public class InnerClassTestCase {

    public void referInnerClass(String s) {
        InnerClass innerClass = new InnerClass() {
            @Override
            public void m() {
                System.out.println("k = " + s);
                System.out.println("Anonymous InnerClass");
            }
        };
    }

    public class InnerClass {
        public void m() {
            System.out.println("InnerClass");
        }
    }
}
