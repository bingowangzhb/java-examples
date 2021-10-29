package com.bgw.java8.map;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * MapTestCase
 *
 * @author wang
 * @since 2020/7/12 11:49
 **/
public class MapTestCase {

    private final static Map<Integer, BigDecimal> B_MAP = new HashMap<>();
    private final static Map<String, Integer> S_MAP = new HashMap<>();

    {
        S_MAP.put("1", 10);
        S_MAP.put("2", 20);
        S_MAP.put("3", 30);
        S_MAP.put("4", 40);
    }

    @Test
    public void testComputeIfPresent() {

        // computeIfAbsent: 如果对于指定key对应的value存在且不为null，那么尝试对该key和当前value应用新的映射函数mappingFunction来计算新值，并输入map
        // 如果映射函数返回null，该映射将被移除（移除对应的key&value）

        B_MAP.put(1, BigDecimal.ONE);
        B_MAP.computeIfPresent(1, (k, v) -> v.add(BigDecimal.TEN));
        System.out.println("BMAP : " + B_MAP);


        S_MAP.put("1", 1);
        S_MAP.computeIfPresent("1", (k, v) -> 3);

        System.out.println("S_MAP: " + S_MAP);


        S_MAP.computeIfPresent("1", (k, v) -> null);
        // 当newValue=null时 移除该key对应value
        System.out.println("S_MAP: " + S_MAP);
    }


    @Test
    public void testComputeIfAbsent() {
        // 如果指定key对应的value为null，那么尝试对该key应用新的映射函数mappingFunction来计算新值，并放入map
        // 如果映射函数返回null，映射将不被记录（不应用）
        S_MAP.computeIfAbsent("122", k -> Integer.valueOf(k + "23"));
        System.out.println("S_MAP = " + S_MAP);
    }

    @Test
    public void testCompute() {
        S_MAP.forEach((k, v) -> {
            S_MAP.compute(k, (key, val) -> Integer.parseInt(key) + val * 10);
        });

        System.out.println("S_MAP = " + S_MAP);
    }

    @Test
    public void testMerge() {
        Map<String, String> ss = new HashMap<>();
        ss.put("1", "abc");
        ss.merge("1", "1", String::concat);

        System.out.println("ss = " + ss);
    }
}
