package com.netty.officaldemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 说明：
 *
 * @author ShujuboDev
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf =(ByteBuf)msg;
        int readableBytes = buf.readableBytes();
        byte[] bytes =new byte[readableBytes];
        buf.readBytes(bytes);
        System.out.println(new String(bytes));

        buf.release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
