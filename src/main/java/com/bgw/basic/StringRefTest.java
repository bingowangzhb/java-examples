package com.bgw.basic;

/**
 * StringRefTest
 *
 * @author zhibin.wang
 * @since 2021/03/12 15:47
 */
public class StringRefTest {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "ab" + "c";

        System.out.println("s1 == s2 = " + s1 == s2);
        System.out.println("s1 == s3 = " + s1 == s3);
        System.out.println("s1 == s2 = " + s1 == s2.intern());
    }


    public static void test2() {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "ab" + "c";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s2.intern());
    }


    public static void test1() {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "ab" + "c";

        System.out.println("11" + s1 == s2);
        System.out.println("22" + s1 == s3);
        System.out.println("33" + s1 == s2.intern());
    }

    public static void test3() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

    public static void test4() {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = new String("a") + new String("bc");
        String s1 = "a";
        String e = s1 + "bc";
        System.out.println(a == b); // true
        System.out.println(b == c); // false
        System.out.println(d == c); // false
        System.out.println(d == b); // true
        System.out.println(e == b);
    }

}
