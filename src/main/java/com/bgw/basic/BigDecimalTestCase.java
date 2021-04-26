package com.bgw.basic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * BigDecimal
 *
 * @author wang
 * @since 2020/7/12 12:59
 **/
public class BigDecimalTestCase {


    /**
     * 1. RoundingMode.HALF_DOWN
     * 舍入模式向“最近的邻居”舍入，除非两个邻居都等距，在这种情况下舍入。 如果舍弃的分数> 0.5，则表现为RoundingMode.UP； 否则，其行为与RoundingMode.DOWN相同。
     *
     *
     *
     *
     *
     */


    public static void main(String[] args) {
        testRm();
        // testRoundingMode();
        // testAdd();
    }


    public static void testRm() {

        MathContext mc = new MathContext(2);


        String s = "100";
        BigDecimal b1 = new BigDecimal(s);
        System.out.println("b1.scale() = " + b1.scale());

        BigDecimal bb = new BigDecimal(s, mc);
        System.out.println("bb.toString() = " + bb.toString());
        System.out.println("bb = " + bb.scale());

        String k = "1E+2";
        BigDecimal b2 = new BigDecimal(k);
        System.out.println("b2 = " + b2.scale());

        String p = "1.0E+2";
        BigDecimal b3 = new BigDecimal(p);
        System.out.println("b3 = " + b3.scale());


        System.out.println("b1.setScale(0, RoundingMode.HALF_UP) = " + b1.setScale(0, RoundingMode.HALF_UP).toString());
        System.out.println("b1.setScale(1, RoundingMode.HALF_UP) = " + b1.setScale(1, RoundingMode.HALF_UP).toString());
        System.out.println("b1.setScale(2, RoundingMode.HALF_UP) = " + b1.setScale(2, RoundingMode.HALF_UP).toString());
        System.out.println("b1.setScale(3, RoundingMode.HALF_UP) = " + b1.setScale(3, RoundingMode.HALF_UP).toString());
        System.out.println("b1.setScale(4, RoundingMode.HALF_UP) = " + b1.setScale(4, RoundingMode.HALF_UP).toString());
        System.out.println("b1.setScale(5, RoundingMode.HALF_UP) = " + b1.setScale(5, RoundingMode.HALF_UP).toString());
        System.out.println("b1.setScale(6, RoundingMode.HALF_UP) = " + b1.setScale(6, RoundingMode.HALF_UP).toString());
        System.out.println("b1.setScale(-1, RoundingMode.HALF_UP) = " + b1.setScale(-1, RoundingMode.HALF_UP).toString());
        System.out.println("b1.setScale(-2, RoundingMode.HALF_UP) = " + b1.setScale(-2, RoundingMode.HALF_UP).toString());
        System.out.println("b1.setScale(-3, RoundingMode.HALF_UP) = " + b1.setScale(-3, RoundingMode.HALF_UP).toString());
        System.out.println("b1.setScale(-4, RoundingMode.HALF_UP) = " + b1.setScale(-4, RoundingMode.HALF_UP).toString());
        System.out.println("b1.setScale(-5, RoundingMode.HALF_UP) = " + b1.setScale(-5, RoundingMode.HALF_UP).toString());
        System.out.println("b1.setScale(-6, RoundingMode.HALF_UP) = " + b1.setScale(-6, RoundingMode.HALF_UP).toString());
        System.out.println("b1.setScale(-5, RoundingMode.HALF_UP) = " + b1.setScale(-5, RoundingMode.HALF_UP).intValue());


    }


    public static void testAdd() {
        double d1 = 0.1, d2 = 0.2;
        double d3 = d1 + d2;



        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        BigDecimal bd3 = bd1.add(bd2);

        System.out.println("d3 = " + d3);
        System.out.println("bd3 = " + bd3);


    }



    private static void testRoundingMode() {
        BigDecimal a = new BigDecimal("25.00");
        BigDecimal r = new BigDecimal("4.7178878787");

        System.out.println(a.multiply(r));
        System.out.println("Scale : 2, HALF_DOWN: " + a.multiply(r).setScale(200, RoundingMode.HALF_DOWN));
        System.out.println("Scale : 2, HALF_UP: " + a.multiply(r).setScale(2, RoundingMode.HALF_UP));
        System.out.println("Scale : 2, DOWN: " + a.multiply(r).setScale(2, RoundingMode.DOWN));
        System.out.println("Scale : 2, UP: " + a.multiply(r).setScale(2, RoundingMode.UP));

        System.out.println("Scale : 1, HALF_DOWN: " + a.multiply(r).setScale(1, RoundingMode.HALF_DOWN));
        System.out.println("Scale : 1, HALF_UP: " + a.multiply(r).setScale(1, RoundingMode.HALF_UP));
        System.out.println("Scale : 1, DOWN: " + a.multiply(r).setScale(1, RoundingMode.DOWN));
        System.out.println("Scale : 1, UP: " + a.multiply(r).setScale(1, RoundingMode.UP));

        System.out.println("Scale : 0, HALF_DOWN: " + a.multiply(r).setScale(0, RoundingMode.HALF_DOWN));
        System.out.println("Scale : 0, HALF_UP: " + a.multiply(r).setScale(0, RoundingMode.HALF_UP));
        System.out.println("Scale : 0, DOWN: " + a.multiply(r).setScale(0, RoundingMode.DOWN));
        System.out.println("Scale : 0, UP: " + a.multiply(r).setScale(0, RoundingMode.UP));
        System.out.println("0UP, 2UP : " + a.multiply(r).setScale(0, RoundingMode.UP).setScale(2, RoundingMode.UP));

        System.out.println("-----------------------------------------------------------------");

        BigDecimal b = new BigDecimal("0.03");

        BigDecimal c = new BigDecimal("235");

        BigDecimal d = c.multiply(BigDecimal.ONE.add(b));
        System.out.println(d);
    }
}
