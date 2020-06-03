package com.bgw.java8.practice.ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/22 11:17
 */
public class OptionalTestCase {

    public static void main(String[] args) {

        Optional<Object> ao = Optional.empty();
        Optional<Object> bo = Optional.empty();

        System.out.println(ao.hashCode());
        System.out.println(bo.hashCode());
        System.out.println(ao == bo);
        System.out.println(ao.equals(bo));

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 7));
    }
}
