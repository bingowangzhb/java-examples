package com.bgw.proxy;

/**
 * @author ambow
 * @since 2021/11/30 13:16
 */
public class MyMethodProxyTest {

    public static void main(String[] args) {

        MyMethodProxyFactory<HelloService> myMethodProxyFactory = new MyMethodProxyFactory<>(HelloService.class);
        HelloService serviceProxy = myMethodProxyFactory.newInstance();
        serviceProxy.sayHi("james");
    }
}
