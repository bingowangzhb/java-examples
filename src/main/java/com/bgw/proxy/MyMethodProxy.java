package com.bgw.proxy;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author ambow
 * @since 2021/11/25 16:48
 */
public class MyMethodProxy<T> implements InvocationHandler {
    private Class<T> intf;


    public MyMethodProxy (Class<T> intf) {
        this.intf = intf;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");
        Object retVal = null;
        try {
            if (Object.class.equals(method.getDeclaringClass())) {
                retVal = method.invoke(this, args);
            }
            else if (isDefaultMethod(method)) {
                retVal = invokeDefaultMethod(proxy, method, args);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

        System.out.println("retVal = " + retVal);
        System.out.println("after");
        // 调用自己的
        return retVal;
    }

    private boolean isDefaultMethod(Method method) {
        return (method.getModifiers()
                & (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC)) == Modifier.PUBLIC
                && method.getDeclaringClass().isInterface();
    }

    private Object invokeDefaultMethod(Object proxy, Method method, Object[] args)
            throws Throwable {
        final Constructor<MethodHandles.Lookup> constructor = MethodHandles.Lookup.class
                .getDeclaredConstructor(Class.class, int.class);
        if (!constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
        final Class<?> declaringClass = method.getDeclaringClass();

        MethodHandles.Lookup lookup = constructor
                .newInstance(declaringClass,
                        MethodHandles.Lookup.PRIVATE | MethodHandles.Lookup.PROTECTED
                                | MethodHandles.Lookup.PACKAGE | MethodHandles.Lookup.PUBLIC);

        return lookup.unreflectSpecial(method, declaringClass)
                .bindTo(proxy)
                .invokeWithArguments(args);
    }
}
