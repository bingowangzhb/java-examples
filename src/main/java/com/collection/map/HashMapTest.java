package com.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 说明：HashMapTest
 *
 * @author ShujuboDev
 */
public class HashMapTest {
    private final static String ABC = "abc";
    private static String abc = "abc";
    private int num;

    public HashMapTest(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        testMap();

//        System.out.println(roundUpToPowerOf2(6));
//        System.out.println(roundUpToPowerOf2(12));
//        System.out.println(roundUpToPowerOf2(18));
//        System.out.println(roundUpToPowerOf2(25));
//
        // System.out.println(highestOneBit(5));
        // :  00000000 00000000 00000000 00000100 4的原码
        // :  10000000 00000000 00000000 00000100 -4的原码 符号位取反，其他不变
        // :  11111111 11111111 11111111 11111011 -4的反码 符号位不变，其他取反
        // :  11111111 11111111 11111111 11111100 -4的补码 计算机存储 反码+1

    }

    private static int roundUpToPowerOf2(int number) {
        int maxCapacity = 1 << 30;

        // assert number >= 0 : "number must be non-negative";
        return number >= maxCapacity
                ? maxCapacity
                : (number > 1) ? highestOneBit((number - 1) << 1) : 1;
    }

    private static int highestOneBit (int i) {
        i |= (i >>  1);
        i |= (i >>  2);
        i |= (i >>  4);
        i |= (i >>  8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }


    private static void testMap() {
        HashMapTest h1 = new HashMapTest(1);
        HashMapTest h2 = new HashMapTest(1);

        int a = 112;
        int b = -128;
        int c = 0;

        System.out.println(h1.hashCode());
        System.out.println(h2.hashCode());

        Map<HashMapTest, Integer> map = new HashMap<>();
        map.put(h1, 1);
        map.put(h2, 2);


        h1 = null;
        h2 = null;

        System.out.println(map);

//        Integer v1 = map.get(h1);
//        System.out.println("v1\t : " + v1);
//        Integer v2 = map.get(h2);
//        System.out.println("v2\t : " + v2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HashMapTest) {
            return this.num == ((HashMapTest)obj).num;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.num * 100 >> 3;
    }
}
