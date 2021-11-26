package com.bgw.proxy;

/**
 * @author ambow
 * @since 2021/11/25 16:56
 */
public interface HelloService {
    String sayHello(String name);

    default String defaultHello() {
        return sayHello("HelloService");
    }
}
