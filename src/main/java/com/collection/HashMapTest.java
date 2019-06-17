package com.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 说明：HashMapTest
 *
 * @author ShujuboDev
 */
public class HashMapTest {

    private int num;

    public HashMapTest(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        HashMapTest h1 = new HashMapTest(1);
        HashMapTest h2 = new HashMapTest(1);

        System.out.println(h1.hashCode());
        System.out.println(h2.hashCode());

        Map<HashMapTest, Integer> map = new HashMap<>();
        map.put(h1, 1);
        map.put(h2, 2);

        Integer v1 = map.get(h1);
        System.out.println("v1\t : " + v1);
        Integer v2 = map.get(h2);
        System.out.println("v2\t : " + v2);

        String abc = "a";

        Thread thread;

        Object o = new Object();

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
