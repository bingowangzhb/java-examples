package com.bgw.proxy;

import java.lang.reflect.Proxy;

/**
 * @author ambow
 * @since 2021/11/25 17:33
 */
public class CommonServiceTest {

    public static void main(String[] args) {

        // HelloService.class.getInterfaces()
        CommonServiceProxy<HelloService> serviceProxy = new CommonServiceProxy<>(HelloService.class);
        HelloService proxyService = (HelloService) Proxy.newProxyInstance(HelloService.class.getClassLoader(), new Class[]{HelloService.class}, serviceProxy);
        Object retVal = proxyService.sayHello("james");
        System.out.println("retVal = " + retVal);


    }
}
