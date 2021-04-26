package com.bgw.basic;

/**
 * IntegerCacheTest
 *
 * @author zhibin.wang
 * @since 2021/03/26 14:16
 */
public class IntegerCacheTest {

    public static void main(String[] args) {

        Integer a = 100, b = 100;
        Integer c = 200, d = 200;

        Integer e = new Integer(20);
        Integer f = new Integer(20);

        Integer g = Integer.valueOf("20");
        Integer h = Integer.valueOf("20");

        System.out.println("(a == b) = " + (a == b));
        System.out.println("(c == d) = " + (c == d));
        System.out.println("(e == f) = " + (e == f));
        System.out.println("(g == h) = " + (g == h));

    }
}
