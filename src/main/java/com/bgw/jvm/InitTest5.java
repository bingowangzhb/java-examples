package com.bgw.jvm;

/**
 * 说明：InitTest5
 *
 * @author ShujuboDev
 */
public class InitTest5 {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();

        // SSClass
        // SuperClass init!
        // SubClass init
        // init SuperClass
        // init SubClass
    }
}


class SSClass {
    static {
        System.out.println("SSClass");
    }
}

class SuperClass extends SSClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

    public SuperClass() {
        System.out.println("init SuperClass");
    }
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }

    static int a;

    public SubClass() {
        System.out.println("init SubClass");
    }
}
