package com.bgw.reflection.invoke;

import java.io.PrintStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 方法句柄(method handle)是对底层方法、构造函数、字段或类似低级操作的类型化、直接可执行的引用，具有参数或返回值的可选转换。
 * 这些转换非常普遍，包括转换、插入、删除和替换等模式
 *
 * @author ambow
 * @since 2021/11/30 13:41
 */
public class MethodHandleExample {


    public static void main(String[] args) throws Throwable {

        Object x, y;
        String s; int i;
        MethodType mt; MethodHandle mh;
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        // mt is (char, char)String
        mt = MethodType.methodType(String.class, char.class, char.class);
        mh = lookup.findVirtual(String.class, "replace", mt);
        s = (String) mh.invokeExact("daddy", 'd', 'n');
        assertEquals(s, "nanny");

        s = (String) mh.invokeWithArguments("sappy", 'p', 'v');
        assertEquals(s, "savvy");

        mt = MethodType.methodType(List.class, Object[].class);
        mh = lookup.findStatic(Arrays.class, "asList", mt);
        assertTrue(mh.isVarargsCollector());

        x = mh.invoke("one", "two");
        System.out.println("x = " + x);
        assertEquals(x, Arrays.asList("one", "two"));

        // mt is (Object, Object, Object)Object
        mt = MethodType.genericMethodType(3);
        mh = mh.asType(mt);
        x = mh.invokeExact((Object)1, (Object)2, (Object)3);
        System.out.println("x = " + x);

        mt = MethodType.methodType(int.class);
        mh = lookup.findVirtual(List.class, "size", mt);
        i = (int) mh.invokeExact(Arrays.asList(1,2,3));
        assertEquals(i, 3);

        mt = MethodType.methodType(void.class, String.class);
        mh = lookup.findVirtual(PrintStream.class, "println", mt);
        mh.invokeExact(System.out, "Hello World");

    }
}
