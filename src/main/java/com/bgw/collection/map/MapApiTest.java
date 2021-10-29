package com.bgw.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ambow
 * @since 2021/9/6 13:30
 */
public class MapApiTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("b", "abc");
        // 计算不存在的值
        map.computeIfAbsent("a", key -> key + "a");
        System.out.println("map = " + map);


        // 计算存在的值
        map.computeIfPresent("b", (k, v) -> k + v);
        map.computeIfPresent("c", (k, v) -> k + v);
        System.out.println("map = " + map);


        // 如果newValue==null不put
        map.compute("a", (k, v) -> k + "@" + v);
        map.compute("d", (k, v) -> k + "@" + v);
        map.compute("e", (k, v) -> null);

        System.out.println("map = " + map);

    }
}
