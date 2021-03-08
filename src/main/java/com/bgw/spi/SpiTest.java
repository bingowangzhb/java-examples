package com.bgw.spi;

import java.util.ServiceLoader;

/**
 * SpiTest
 *
 * @author wang
 * @since 2020/9/26 18:06
 **/
public class SpiTest {

    public static void main(String[] args) {

        ServiceLoader<HelloService> services = ServiceLoader.load(HelloService.class);
        for (HelloService helloService : services) {
            helloService.sayHello("james");
        }

    }
}
