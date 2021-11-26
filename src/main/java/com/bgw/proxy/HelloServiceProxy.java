package com.bgw.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ambow
 * @since 2021/11/25 16:57
 */
public class HelloServiceProxy implements InvocationHandler {

    private HelloService helloService;

    public HelloServiceProxy(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before invoke method");
        Object result = method.invoke(helloService, args);
        System.out.println("after invoke method");

        return result;
    }
}
