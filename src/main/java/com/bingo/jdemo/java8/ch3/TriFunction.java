package com.bingo.jdemo.java8.ch3;

/**
 * 说明：
 *
 * @author ShujuboDev
 */
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
