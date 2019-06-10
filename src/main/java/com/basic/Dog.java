package com.basic;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/18 10:08
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
