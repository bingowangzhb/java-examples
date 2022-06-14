package com.bgw.reflection.beans;

public class Son extends Father {

    private String privateSonField;

    public String publicSonField;

    private static String privateStaticSonField;

    public static String publicStaticSonField;

    private void privateSonMethod() {
        System.out.println("privateSonField");
    }

    public void publicSonMethod() {
        System.out.println("publicSonMethod");
    }

    private static void privateStaticSonMethod() {
        System.out.println("privateStaticSonMethod");
    }

    public static void publicStaticSonMethod() {
        System.out.println("publicStaticSonMethod");
    }


    @Override
    public void publicFatherMethod() {
        System.out.println("Son Override publicFatherMethod");
    }
}
