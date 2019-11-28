package com.bgw.basic.sample2;

/**
 * 说明：
 *
 * @author wangzhb
 */
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    protected void someAction() {
        System.out.println("HelloWorld");
    }
}

