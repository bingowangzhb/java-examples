package com.bgw.java8.practice.ch11;

import java.math.BigDecimal;

/**
 * Quote
 *
 * @author wang
 * @since 2020/7/5 23:58
 **/
public class Quote {

    private final String shopName;
    private final BigDecimal price;
    private final Discount.Code discountCode;

    public Quote(String shopName, BigDecimal price, Discount.Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    public static Quote parse(String s) {
        String[] ss = s.split(":");
        String shopName = ss[0];
        BigDecimal price = new BigDecimal(ss[1]);
        Discount.Code code = Discount.Code.valueOf(ss[2]);
        return new Quote(shopName, price, code);
    }


    public String getShopName() {
        return shopName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}
