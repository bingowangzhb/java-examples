package com.bgw.collection.set;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * 说明：HashSetTest
 *
 * @author ShujuboDev
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");

        System.out.println(set);

        Map<String, Object> table = new Hashtable<>();
        table.put(null, 1);
        table.put(null, null);

    }
}
