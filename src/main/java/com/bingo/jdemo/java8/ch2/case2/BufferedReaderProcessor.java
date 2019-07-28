package com.bingo.jdemo.java8.ch2.case2;

import java.io.BufferedReader;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/19 14:22
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws Exception;
}
