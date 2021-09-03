package com.bgw.generic.bridge;

/**
 * @author ambow
 * @since 2021/7/30 14:59
 */
public class Consumer {

    String getType() {
        return "Consumer";
    }


    Number getPrice(double price) {
        return 0.9 * price;
    }
}
