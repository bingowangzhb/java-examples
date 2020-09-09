package com.bgw.basic;

/**
 * StringAppendTest
 *
 * @author zhibin.wang
 * @since 2020/09/07 14:48
 */
public class StringAppendTest {

    public static void main(String[] args) {
        test2();
    }

    private static void test2() {
        String s = new String("1");
        // s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        // s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

    private static void test3() {
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }

    private static void test1() {
        final String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1 == s2);

        String s3 = "abc";
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);


        String s4 = s1 + "d";

        String s5 = "abc" + "d";
        String s6 = "abcd";
        System.out.println(s4 == s5);
        System.out.println(s6 == s5);
    }

}
