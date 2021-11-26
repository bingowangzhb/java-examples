package com.bgw.io.bio;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.util.Arrays;

/**
 * BufferedInputStreamTestCase
 *
 * @author zhibin.wang
 * @since 2019-10-21 14:44
 **/
public class BufferedInputStreamTestCase {

    public static void main(String[] args) throws Exception {

        String s = "1";
        byte[] ss = s.getBytes();
        System.out.println("s.getBytes()  = " + Arrays.toString(s.getBytes()));

        byte[] bytes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        BufferedInputStream bis = new BufferedInputStream(bais);

        bis.mark(3);
        System.out.println(bis.read());
        System.out.println(bis.read());
        System.out.println(bis.read());
        System.out.println(bis.read());

        bis.reset();
        System.out.println("-------------");
        System.out.println(bis.read());
        System.out.println(bis.read());
        System.out.println(bis.read());
        System.out.println(bis.read());

        bis.mark(6);
        bis.reset();
        System.out.println(bis.read());



    }

}
