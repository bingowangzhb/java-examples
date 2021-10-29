package com.bgw.collection.map;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author ambow
 * @since 2021/9/6 9:52
 */
public class MultiValueMapTest {


    public static void main(String[] args) {

        Multimap<String, String> multimap = HashMultimap.create();

        multimap.put("fruits", "apple");
        multimap.put("fruits", "banana");
        multimap.put("vegetables", "potato");
        multimap.put("vegetables", "tomato");

        //
        System.out.println("multimap = " + multimap);

    }


}
