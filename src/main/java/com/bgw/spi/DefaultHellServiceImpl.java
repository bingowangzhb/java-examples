package com.bgw.spi;

/**
 * DefaultHellServiceImpl
 *
 * @author wang
 * @since 2020/9/26 18:05
 **/
public class DefaultHellServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
}
