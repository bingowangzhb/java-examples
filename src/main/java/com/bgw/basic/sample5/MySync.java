package com.bgw.basic.sample5;

/**
 * MySync
 *
 * @author zhibin.wang
 * @since 2020/09/29 13:58
 */
public class MySync extends AbsSynchronizer {

    public static void main(String[] args) {

        MySync mySync = new MySync();
        mySync.setState(3);
        System.out.println(mySync.getState());
    }
}
