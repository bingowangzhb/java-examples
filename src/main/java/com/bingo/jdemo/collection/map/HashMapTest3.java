package com.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 说明：HashMapTest3
 *
 * @author ShujuboDev
 */
public class HashMapTest3 {

    @Override
    public String toString() {
        System.out.println("===================调用了toString===================");
        return super.toString();
    }

    public static void main(String[] args) {
        //HashMapTest3 t = new HashMapTest3();
        testSourceCode();
    }


    private static void testSourceCode() {
        Map<String, String> map = new HashMap<>();
        Set<Map.Entry<String, String>> mapSet = map.entrySet();
        System.out.println(null == mapSet);
        map.put("hello", "hello");
        map.put("elloh", "b");
        map.put("llohe", "c");
        map.put("lohel", "d");
        map.put("ohell", "e");
        map.put("hello", "f");

        System.out.println(mapSet);
    }
}
