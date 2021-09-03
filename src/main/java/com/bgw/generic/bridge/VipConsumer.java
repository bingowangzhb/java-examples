package com.bgw.generic.bridge;

import java.lang.reflect.Method;

/**
 * @author ambow
 * @since 2021/7/30 15:01
 */
public class VipConsumer extends Consumer {

    @Override
    String getType() {
        return "VipConsumer";
    }

    @Override
    Double getPrice(double price) {
        return 0.8 * price;
    }

    public static void main(String[] args) {
        for (Method method : VipConsumer.class.getDeclaredMethods()) {
            System.out.println("method : " + method.getName() + ", isBridge:" + method.isBridge());
        }
    }
}
