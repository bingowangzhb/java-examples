package com.bgw.reflection.method.accessor;

import java.lang.reflect.Method;

/**
 * @author ambow
 * @since 2021/11/30 10:18
 */
public class TestMethodAccessor {

    public static void main(String[] args) throws Exception {

        Class<?> clz = Class.forName("com.bgw.reflection.method.accessor.Foo");
        Object obj = clz.newInstance();
        Method m = clz.getMethod("foo", String.class);
        for (int i = 0; i < 16; i++) {
            m.invoke(obj, Integer.toString(i));
        }
    }
}
