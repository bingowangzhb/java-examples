package com.bgw.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ambow
 * @since 2021/11/25 17:13
 */
public class HelloServiceProxyTest {


    public static void main(String[] args) {
        //jdkDyProxy();


        //System.out.println("helloService.getClass().getDeclaringClass() = " + helloService.getClass().getDeclaringClass());

        testDeclaringClass();
    }

    private static void testDeclaringClass() {

        System.out.println("HelloService.class.getDeclaringClass() = " + HelloService.class.getDeclaringClass());
        System.out.println("HelloServiceImpl.class.getDeclaringClass() = " + HelloServiceImpl.class.getDeclaringClass());


        Method[] serviceMethods = HelloService.class.getMethods();
        Method[] implMethods = HelloServiceImpl.class.getMethods();


        for (Method method : serviceMethods) {
            System.out.println(method.getName() + " : method.getDeclaringClass() = " + method.getDeclaringClass());
        }

        System.out.println(" ======================================================================================= ");
        for (Method method : implMethods) {
            System.out.println(method.getName() + " : method.getDeclaringClass() = " + method.getDeclaringClass());
        }
    }


    private static void jdkDyProxy() {
        HelloService helloService = new HelloServiceImpl();
        HelloServiceProxy proxyService = new HelloServiceProxy(helloService);
        HelloService proxyHelloService = (HelloService) Proxy.newProxyInstance(helloService.getClass().getClassLoader(),
                helloService.getClass().getInterfaces(), proxyService);

        String helleWord = proxyHelloService.sayHello("ambow");
        System.out.println("helleWord = " + helleWord);
    }
}
