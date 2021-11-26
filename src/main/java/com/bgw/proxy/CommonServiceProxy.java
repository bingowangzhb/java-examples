package com.bgw.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author ambow
 * @since 2021/11/25 17:30
 */
public class CommonServiceProxy <T> implements InvocationHandler {

    private Class<T> intf;


    public CommonServiceProxy (Class<T> intf) {
        this.intf = intf;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");
        try {
            if (Object.class.equals(method.getDeclaringClass())) {

            } else if (isDefaultMethod(method)) {

            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.out.println("after");
        return "";
    }

    private boolean isDefaultMethod(Method method) {
        return (method.getModifiers()
                & (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC)) == Modifier.PUBLIC
                && method.getDeclaringClass().isInterface();
    }
}
