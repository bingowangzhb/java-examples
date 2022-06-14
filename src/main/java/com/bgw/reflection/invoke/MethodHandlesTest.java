package com.bgw.reflection.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author ambow
 * @since 2021/11/26 18:09
 */
public class MethodHandlesTest {

    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        void thinking() {
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = lookup().findSpecial(GrandFather.class,
                        "thinking", mt, getClass());
                mh.invoke(this);
            }
            catch (Throwable e) {
            }
        }
    }

    public static void main(String[] args) {
        // Son :< Father :< Grandfather
        (new MethodHandlesTest().new Son()).thinking();
    }
}
