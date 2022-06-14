package com.bgw.reflection.beans;

public class Father {

    private String privateFatherField;

    public String publicFatherField;

    private static String privateStaticFatherField;

    public static String publicStaticFatherField;

    private void privateFatherMethod() {
        System.out.println("privateFatherMethod");
    }

    public void publicFatherMethod() {
        System.out.println("publicFatherMethod");
    }

    private static void privateStaticFatherMethod() {
        System.out.println("privateStaticFatherMethod");
    }

    public static void publicStaticFatherMethod() {
        System.out.println("publicStaticFatherMethod");
    }
}
