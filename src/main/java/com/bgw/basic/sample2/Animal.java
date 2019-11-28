package com.bgw.basic.sample2;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/18 10:06
 */
public abstract class Animal {
    private final String name;


    public Animal(String name) {
        this.name = name;
    }

    protected abstract void someAction();
}




