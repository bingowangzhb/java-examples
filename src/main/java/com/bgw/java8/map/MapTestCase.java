package com.bgw.java8.map;

import java.math.BigDecimal;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * MapTestCase
 *
 * @author wang
 * @since 2020/7/12 11:49
 **/
public class MapTestCase {


    public static void main(String[] args) {

        Map<Integer, BigDecimal> map = new HashMap<>();
        map.put(1, BigDecimal.ONE);



        System.out.println(map);

        map.computeIfPresent(1, (k, v) -> v.add(BigDecimal.TEN));

        System.out.println(map);

    }

}
