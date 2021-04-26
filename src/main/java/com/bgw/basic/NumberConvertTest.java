package com.bgw.basic;

/**
 * NumberConvertTest
 *
 * @author zhibin.wang
 * @since 2021/03/19 09:25
 */
public class NumberConvertTest {

    public static void main(String[] args) {
        // 32
        // 0000 0000 0000 0000 1111 1111 1111 1111
        int a = 65535;
        // 16
        // 1 111 1111 1111 1111
        // 1 000 0000 0000 0001 补码 = 取反+1
        short b = (short)a;
        // 8
        //
        byte c = (byte)a;
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        int d = ~4;
        System.out.println("d = " + d);
        //  5 原码 0 000 0000 0000 0000 0000 0000 0000 0101
        // -5 原码 1 000 0000 0000 0000 0000 0000 0000 0101
        // -5 反码 1 111 1111 1111 1111 1111 1111 1111 1010
        // -5      1 111 1111 1111 1111 1111 1111 1111 1011
        System.out.println("Integer.toBinaryString(-5) = " + Integer.toBinaryString(d));
        System.out.println("Integer.toBinaryString(5) = " + Integer.toBinaryString(5));
        System.out.println("Integer.toHexString(d) = " + Integer.toHexString(d));

        byte e = -128; //[-128, 127]
        System.out.println("Integer.toBinaryString(e) = " + Integer.toBinaryString(e));

        System.out.println("Integer.parseInt(\"0111111 1011\", 2) = " + Integer.parseInt("01111111011", 2));



        // 011 1111 1011
        double d1 = 0.1, d2 = 0.2, d3;
        d3 = d1 + d2;
        double d4 = 0.3;
        System.out.println("d3 = " + d3);
        System.out.println("d4 = " + d4);

        float f1 = 34.6f;
        float f2 = 34.5f;
        float f3 = 34.0f;
        System.out.printf("34.6-34.0=%f\n", f1-f3);
        System.out.printf("34.5-34.0=%f\n", f2-f3);


    }
}
