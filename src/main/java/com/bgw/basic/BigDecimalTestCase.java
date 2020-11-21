package com.bgw.basic;

import java.math.BigDecimal;
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

        BigDecimal a = new BigDecimal("25.00");
        BigDecimal r = new BigDecimal("4.7178878787");

        System.out.println(a.multiply(r));
        System.out.println("Scale : 2, HALF_DOWN: " + a.multiply(r).setScale(2, RoundingMode.HALF_DOWN));
        System.out.println("Scale : 2, HALF_UP: " + a.multiply(r).setScale(2, RoundingMode.HALF_UP));
        System.out.println("Scale : 2, DOWN: " + a.multiply(r).setScale(2, RoundingMode.DOWN));
        System.out.println("Scale : 2, UP: " + a.multiply(r).setScale(2, RoundingMode.UP));

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
