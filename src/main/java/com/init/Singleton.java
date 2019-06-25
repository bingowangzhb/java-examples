package com.init;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/13 15:09
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    private static int x = 2;
    private static int y;

    //private static Singleton instance = new Singleton();



    private Singleton() {
        x++;
        y++;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

        System.out.println(Singleton.x);
        System.out.println(Singleton.y);
    }
}
