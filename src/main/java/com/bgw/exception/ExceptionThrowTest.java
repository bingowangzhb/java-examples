package com.bgw.exception;

/**
 * ExceptionThrowTest
 *
 * @author wang
 * @since 2020/7/28 21:38
 **/
public class ExceptionThrowTest {


    public static void main(String[] args) {

        ExceptionThrowTest test = new ExceptionThrowTest();
        //test.wrong();
        try {
            test.right2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void wrong() {
        try {
            System.out.println("info");
            throw new RuntimeException("info ex");
        } finally {
            System.out.println("infof");
            throw new RuntimeException("infof ex");
        }

    }


    public void right2() throws Exception {
        Exception e = null;
        try {
            System.out.println("try");
            throw new RuntimeException("try");
        } catch (Exception ex) {
            e = ex;
        } finally {
            System.out.println("finally");
            try {
                throw new RuntimeException("finally");
            } catch (Exception ex) {
                if (e!= null) {
                    e.addSuppressed(ex);
                } else {
                    e = ex;
                }
            }
        }
        throw e;
    }
}
