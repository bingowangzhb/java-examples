package com.bgw.exception;

/**
 * TryCatchFinallyReturnIntTest
 *
 * @author zhibin.wang
 * @since 2020/09/07 13:22
 */
public class TryCatchFinallyReturnTest {


    public static void main(String[] args) {
        System.out.println("returnInt1() = " + returnInt1());
        System.out.println("returnInt2() = " + returnInt2());
    }

    public static int returnInt1() {
        int a = 1;
        try {
            System.out.println(a / 0);
            a = 2;
        } catch (Exception e) {
            a = 3;
            return a;
        } finally {
            a = 4;
            System.out.println("a = " + a);
        }

        return a;
    }

    public static int returnInt2() {
        int a = 1;
        try {
            System.out.println(a / 0);
            a = 2;
        } catch (Exception e) {
            a = 3;
            return a;
        } finally {
            a = 4;
            System.out.println("a = " + a);
            return a;
        }
    }

    public static void returnObject() {

    }

}
