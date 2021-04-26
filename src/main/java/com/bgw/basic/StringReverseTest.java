package com.bgw.basic;

/**
 * StringReverseTest
 *
 * @author zhibin.wang
 * @since 2021/03/23 14:47
 */
public class StringReverseTest {
    public static void main(String[] args) {
        String a = "hi,hello world!";

        for (int i = a.length() - 1; i > 0; i--) {
            System.out.println("a.charAt(i) = " + a.charAt(i));

        }
    }
}
