package com.bgw.jvm.sample1;

/**
 * ClassA
 *
 * @author zhibin.wang
 * @since 2019-11-22 14:50
 **/
public class ClassA {
    static {
        System.out.println("---------static ClassA-----------");
    }

    public ClassA() {
        System.out.println("---------Constructor ClassA---------");
    }
}
