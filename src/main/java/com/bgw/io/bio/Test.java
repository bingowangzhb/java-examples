package com.bgw.io.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author ambow
 * @since 2021/10/21 17:33
 */
public class Test {

    public static void main(String[] args) throws IOException {
        SocketAddress address = new InetSocketAddress("baidu.com", 80);
        Socket local = new Socket();
        local.connect(address);
        System.out.println("local = " + local);
    }
}
