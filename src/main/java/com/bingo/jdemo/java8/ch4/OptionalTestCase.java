package com.bingo.jdemo.java8.ch4;

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

    }
}
