package com.bgw.proxy;

/**
 * @author ambow
 * @since 2021/11/25 17:14
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        String helloMessage = "Hello, " + name;
        System.out.println(helloMessage);
        return helloMessage;
    }
}
