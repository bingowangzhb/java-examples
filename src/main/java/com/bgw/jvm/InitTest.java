package com.bgw.jvm;

/**
 * 说明：InitTest
 *
 * @author ShujuboDev
 */
public class InitTest {

    public static void main(String[] args) {
        func();
    }

    static InitTest it = new InitTest();

    static void func() {
    }
}


class Apple {

}
