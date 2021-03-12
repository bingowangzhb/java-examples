package com.bgw.reflection;

import java.lang.reflect.Constructor;

/**
 * SyntheticSample
 *
 * @author zhibin.wang
 * @since 2021/03/10 17:06
 */
public class SyntheticSample {


    public static void main(String[] args) throws NoSuchMethodException {

        InnerClass innerClass = new InnerClass();
        System.out.println("innerClass.s = " + innerClass.s);
        
        
        boolean isSynthetic1 = SyntheticSample.class.isSynthetic();
        System.out.println("isSynthetic1 = " + isSynthetic1);

        boolean i2 = innerClass.getClass().isSynthetic();
        System.out.println("i2 = " + i2);
        
        
        Constructor c = SyntheticSample.InnerClass.class.getConstructor(null);
        System.out.println("c.isSynthetic() = " + c.isSynthetic());
        
        

    }



    private static class InnerClass {
        private String s = "inner";
    }

    
    
}
