package com.bgw.reflection.method;

import com.bgw.reflection.beans.Drivable;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ambow
 * @since 2021/11/26 16:43
 */
public class MethodReflectionTest {

    @Test
    public void testDeclaringClass() {

        List<Method> methods = new ArrayList<>(Arrays.asList(Drivable.class.getMethods()));
        for (Method method : methods) {
            System.out.println(method.getName() + ".getDeclaringClass() : " + method.getDeclaringClass());
        }
        System.out.println(" ============================================================== ");
        methods.stream()
                .filter(m -> m.getDeclaringClass().equals(Object.class))
                .collect(Collectors.toList())
                .forEach(m -> {
                    System.out.println(m.getName() + ".getDeclaringClass() : " + m.getDeclaringClass());
                });
    }


}
