package com.bgw.basic;

import java.util.Arrays;

/**
 * VariableArgsTestCase
 *
 * @author zhibin.wang
 * @since 2019-11-26 15:25
 **/
public class VariableArgsTestCase {

    public static void main(String[] args) {
        int a = 100;
        varArgMethod(5, 7, 8, 9, 10, a);
    }

    public static void varArgMethod(int b, int... arr) {
        //索引遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
