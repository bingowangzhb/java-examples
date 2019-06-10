package com.nio;

import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * 说明：
 *
 * @author ShujuboDev
 */
public class NioServer {
    public static void main(String[] args) throws Exception {

        //int[] ports = new int[]{6001, 6002, 6003, 6004};
        int port = 9001;

        Selector selector = Selector.open();


        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        System.out.println(serverSocketChannel.hashCode());
        serverSocketChannel.bind(new InetSocketAddress("localhost", port));
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            //一直等待,直至有信道准备好了I/O操作
            if (selector.select(3000) == 0) {
                //在等待信道准备的同时，也可以异步地执行其他任务，
                //这里只是简单地打印"."
                System.out.println("等待连接...");
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(key -> {
                final ServerSocketChannel server = (ServerSocketChannel) key.channel();
                System.out.println(server.hashCode());
                if (key.isAcceptable()) {
                    try {
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);
                        System.out.println(client.getLocalAddress() + " connected!");
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (key.isReadable()) {

                }
            });

        }


    }
}
