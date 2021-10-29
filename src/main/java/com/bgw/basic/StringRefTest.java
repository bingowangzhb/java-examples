package com.bgw.basic;

import java.util.concurrent.CyclicBarrier;

/**
 * StringRefTest
 *
 * @author zhibin.wang
 * @since 2021/03/12 15:47
 */
public class StringRefTest {

    public static void main(String[] args) throws Exception {
//        String s = new String("abc");
//        System.out.println(s);
//        CyclicBarrier barrier = new CyclicBarrier(2);
//        barrier.await();

        String a = "java";

        appendStr(a);

        System.out.println("a = " + a);

    }

    private static void appendStr(String a) {
        a += "d";
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
        // s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String k = s3.intern();

        System.out.println("s3.intern.hashCode= " + k.hashCode());

        System.out.println(s3.hashCode());

        String s4 = "11";
        System.out.println(s4.hashCode());
        System.out.println(s3 == s4);


    }

    public static void test4() {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = new String("a") + new String("bc");
        d.intern();
        String s1 = "a";
        String e = s1 + "bc";
        System.out.println(a == b); // true
        System.out.println(b == c); // false
        System.out.println(d == c); // false

        System.out.println(d == b); // true
        System.out.println(e == b);
    }

    public static void test5() {
        String s0 = new String("1") + new String("x");
        String s1 = "1x";
        s0.intern();
        System.out.println(s1 == s0);//true

        System.out.println("s1 = " + s1.hashCode());
        System.out.println("System.identityHashCode(s1) = " + System.identityHashCode(s1));


    }

    public static void test6(){
        String s0 = new String("1") + new String("x");
        String s2 = s0.intern();
        String s1 = "1x";
        System.out.println(s2 == s0);//true
        System.out.println(s2 == s1);//true
        System.out.println(s0 == s1);//true
        System.out.println("---------------------------------------");
        String s3 = new String("1") + new String("x");
        String s5 = s3.intern();
        String s4 = "1x";
        System.out.println(s5 == s3); //false //前面已经存在字符串常量1x指向s0，s5指向的就是s0
        System.out.println(s5 == s4); //true
        System.out.println(s3 == s4); //false //前面已经存在字符串常量1x指向s0，s4指向的就是s0
        System.out.println(s5 == s0); //true
        System.out.println(s4 == s0); //true
    }
}