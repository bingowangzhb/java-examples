package com.bgw.java8.practice.ch3;

/**
 * 说明：
 *
 * @author ShujuboDev
 */
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
