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

    public static void main(String[] args) {

        BigDecimal a = new BigDecimal("25.00");
        BigDecimal r = new BigDecimal("4.7178878787");

        System.out.println(a.multiply(r));
        System.out.println(a.multiply(r).setScale(2, RoundingMode.HALF_DOWN));
        System.out.println(a.multiply(r).setScale(          2, RoundingMode.HALF_UP));
        System.out.println(a.multiply(r).setScale(2, RoundingMode.DOWN));
        System.out.println(a.multiply(r).setScale(2, RoundingMode.UP));

        System.out.println(a.multiply(r).setScale(0, RoundingMode.HALF_DOWN).setScale(2));
        System.out.println(a.multiply(r).setScale(0, RoundingMode.HALF_UP));
        System.out.println(a.multiply(r).setScale(0, RoundingMode.DOWN));
        System.out.println(a.multiply(r).setScale(0, RoundingMode.UP));




    }
}
