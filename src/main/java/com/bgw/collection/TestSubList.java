package com.bgw.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ambow
 * @since 2021/8/11 11:24
 */
public class TestSubList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> subList = list.subList(0, 2);
        list.set(0, 4);
        // subList返回的是View
        System.out.println("subList = " + subList);

    }
}
