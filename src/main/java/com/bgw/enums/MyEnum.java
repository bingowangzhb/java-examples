package com.bgw.enums;

import java.util.Arrays;

/**
 * @author ambow
 * @since 2021/9/7 15:38
 */
public enum  MyEnum {

    GET, PUT, POST;

    public static void main(String[] args) {
        Arrays.stream(MyEnum.values()).forEach(n -> System.out.println(n.name()));
    }

}
