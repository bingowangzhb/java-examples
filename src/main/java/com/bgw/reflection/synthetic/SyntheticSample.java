package com.bgw.reflection.synthetic;

import java.lang.reflect.Field;

/**
 * SyntheticSample
 *
 * @author zhibin.wang
 * @since 2021/03/10 17:06
 */
public class SyntheticSample {

    public void sayHello() {
        System.out.println("Hello World");
    }

    private class InnerSyntheticSample {
        // 内部类默认持有内部类的引用this$0
        private SyntheticSample this$;
        public void hi() {
            sayHello();
        }

    }

    public static void main(String[] args) {
        for (Field field : SyntheticSample.InnerSyntheticSample.class.getDeclaredFields()) {
            System.out.println(field.getName() + ", " + field.isSynthetic());
        }
    }
}
