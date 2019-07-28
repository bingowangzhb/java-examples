package com.bgw.annotation.myjunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 说明：
 *
 * @author ab
 */
public class MyUnit {

    public static void main(String[] args) throws Exception {
        Class<MyServiceTestCase> clazz = MyServiceTestCase.class;
        Object object = clazz.newInstance();

        Method[] methods = object.getClass().getMethods();
        List<Method> myBeforeMethods = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(MyBefore.class))
                .collect(Collectors.toList());

        List<Method> myTestMethods = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(MyTest.class))
                .collect(Collectors.toList());

        List<Method> myAfterMehtods = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(MyAfter.class))
                .collect(Collectors.toList());

        myTestMethods.forEach(method -> {
            myBeforeMethods.forEach(beforeMethod -> {
                try {
                    beforeMethod.invoke(object);
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });

            try {
                method.invoke(object);
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            myAfterMehtods.forEach(afterMethod -> {
                try {
                    afterMethod.invoke(object);
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        });

    }
}
