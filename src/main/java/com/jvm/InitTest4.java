package com.jvm;

/**
 * 说明：InitTest4
 *
 * @author ShujuboDev
 */
public class InitTest4 {
    private int j = getI();
    private int i = 1;

    public InitTest4() {
        i = 2;
    }

    private int getI() {
        return i;
    }

    public static void main(String[] args) {
        InitTest4 ii = new InitTest4();
        System.out.println(ii.j);
    }
}
