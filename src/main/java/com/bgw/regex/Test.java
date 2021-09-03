package com.bgw.regex;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author ambow
 * @since 2021/7/12 14:34
 */
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "It is 知乎日报";
        System.out.println("Arrays.toString(s.getBytes()) = " + Arrays.toString(s.getBytes()));
        // I    t        i    s
        // it is \u77e5\u4e4e\u65e5\u62a5
        //[73, 116, 32, 105, 115, 32, -25, -97, -91, -28, -71, -114, -26, -105, -91, -26, -118, -91]


        byte[] b = "知".getBytes(StandardCharsets.UTF_8);
        System.out.println("b = " + Arrays.toString(b));

        System.out.println("Integer.toBinaryString(-25) = " + Integer.toBinaryString(-25));

    }

}
