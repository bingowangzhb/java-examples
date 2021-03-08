package com.bgw.spi;

/**
 * ChineseHelloServiceImpl
 *
 * @author wang
 * @since 2020/9/26 18:04
 **/
public class ChineseHelloServiceImpl implements HelloService {


    @Override
    public void sayHello(String name) {
        System.out.println("你好，" + name);
    }
}
