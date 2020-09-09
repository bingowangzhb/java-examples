package com.bgw.basic;

/**
 * SwapValueTest
 *
 * @author zhibin.wang
 * @since 2020/09/07 13:57
 */
public class SwapValueTest {

    public static void main(String[] args) {
        //swap(2, 45);
        swap2();
    }


    public static void swap(int a, int b) {
        System.out.printf("a=%d, b=%d", a, b);
        System.out.println();
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.printf("a=%d, b=%d", a, b);
    }

    public static void swap2() {
        int a = 12;
        int b = 8;

        // a = 8 + 4 b = 8
        // a : 1100
        // b : 1000
        // ^ : 0100  相同为0，不同为1
        // 0 : 0000

        // 本身异或本身=0
        // 本身异或0=本身
        System.out.printf("a^b = %d", a ^ b);
        System.out.println();
        System.out.printf("a^a = %d", a ^ a);
        System.out.printf("a^0 = %d", a ^ 0);

    }
}
