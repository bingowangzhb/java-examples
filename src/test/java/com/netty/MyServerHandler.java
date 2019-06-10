package com.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpObject;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/12/29 9:29
 */
public class MyServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        System.out.println(channelHandlerContext.channel().remoteAddress());


    }
}
