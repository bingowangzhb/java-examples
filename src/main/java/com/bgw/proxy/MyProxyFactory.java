package com.bgw.proxy;

import java.lang.reflect.Proxy;

/**
 * @author ambow
 * @since 2021/11/25 16:50
 */
public class MyProxyFactory<T> {

    private final Class<T> intf;

    public MyProxyFactory(Class<T> intf) {
        this.intf = intf;
    }

    protected T newInstance(MyProxy<T> myProxy) {
        return null;
    }
}
