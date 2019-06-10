package com.annotation.myjunit;

/**
 * 说明：
 *
 * @author ab
 */
public class MyServiceTestCase {

    /**
     * before
     */
    @MyBefore
    public void before() {
        System.out.println("====================before===================");
    }

    /**
     * after
     */
    @MyAfter
    public void after() {
        System.out.println("======================after=====================");
    }

    /**
     * test
     */
    @MyTest
    public void testInsert() {
        System.out.println("===================testInsert=================");
    }

    /**
     * test
     */
    @MyTest
    public void testUpdate() {
        System.out.println("===================testUpdate=================");
    }
}
