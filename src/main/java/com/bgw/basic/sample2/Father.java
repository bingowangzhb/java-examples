package com.bgw.basic.sample2;

/**
 * Father
 *
 * @author zhibin.wang
 * @since 2019-10-18 10:54
 **/
public class Father {
    private int x;

    public Father() {
        System.out.println("---Father---");
        // x = 10;
        // showX();
    }

    public void showX() {
        System.out.println(x);
    }

    public static void main(String[] args) {
        Son s = new Son();

        // s.showX();
        // s.showSonX();
    }
}

class Son extends Father {
    private int x;
    public Son() {
        // 默认调用父类的构造无参方法
        System.out.println("--Son---无参构造--");
        x = 100;
    }

    public Son(int x) {
        this();
        this.x = x;
    }

    public void showSonX() {
        System.out.println(x);
    }
}
