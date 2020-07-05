package com.bgw.java8.practice.ch11;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * Discount
 *
 * @author wang
 * @since 2020/7/5 23:50
 **/
public class Discount {

    public enum Code {
        NONE(0), SLIVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }


    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    private static BigDecimal apply(BigDecimal price, Code discountCode) {
        delay();
        return price.multiply(BigDecimal.valueOf(100 - discountCode.percentage).divide(BigDecimal.valueOf(100), 2));
    }

    private static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
