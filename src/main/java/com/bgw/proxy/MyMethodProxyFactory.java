package com.bgw.proxy;

import java.lang.reflect.Proxy;

/**
 * @author ambow
 * @since 2021/11/25 16:50
 */
public class MyMethodProxyFactory<T> {

    private final Class<T> intf;

    public MyMethodProxyFactory(Class<T> intf) {
        this.intf = intf;
    }

    protected T newInstance() {
        MyMethodProxy<T> methodProxy = new MyMethodProxy<>(intf);
        return (T) Proxy.newProxyInstance(intf.getClassLoader(), new Class[] { intf }, methodProxy);
    }
}
