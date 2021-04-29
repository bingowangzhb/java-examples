package com.bgw.reflection;

public class Man extends People implements Drivable {

    private String privateManField;

    public String publicManField;

    private static String privateStaticManField;

    public static String publicStaticManField;

    @Override
    public void drive() {}

    private void privateManMethod() {}

    public void publicManMethod() {}

    private static void privateStaticManMethod() {}

    public static void publicStaticManMethod() {}
}
