package com.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/12/29 9:26
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline channelPipeline = socketChannel.pipeline();

        channelPipeline.addLast(new HttpServerCodec());

        channelPipeline.addLast(new MyServerHandler());


    }
}
