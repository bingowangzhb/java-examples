package com.bingo.jdemo.io.nio.c1;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/24 16:56
 */
public class NioTestCase {

    @Test
    public void test() {

        final Charset defaultCharset = Charset.defaultCharset();
        final String text = "Lorem中";

        final ByteBuffer byteBufferA = ByteBuffer.wrap(text.getBytes());
        final ByteBuffer byteBufferB = defaultCharset.encode(text);



        final String s = new String(byteBufferA.array());
        final CharBuffer charBuffer = defaultCharset.decode(byteBufferB);

        System.out.println(s.length());
        System.out.println(new String(charBuffer.array()).length());


    }
}
