package com.bingo.jdemo.jvm;

/**
 * 说明：JvmTest
 *
 * @author
 */
public class JvmTest {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        System.out.println(s.value1);
        System.out.println(s.value2);

        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s2.value1);
        System.out.println(s2.value2);
    }
}

class Singleton {
    private static Singleton s = new Singleton();
    public static int value1;
    public static int value2 = 0;

    public Singleton() {
        value1++;
        value2++;
    }

    public static Singleton getInstance() {
        return s;
    }

}

class Singleton2 {
    public static int value1;
    public static int value2 = 0;
    private static Singleton2 s2 = new Singleton2();

    public Singleton2() {
        value1++;
        value2++;
    }

    public static Singleton2 getInstance() {
        return s2;
    }
}

