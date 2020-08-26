package com.bgw.thd;

/**
 * FooService
 *
 * @author zhibin.wang
 * @since 2020/08/24 11:26
 */
public class FooService {

    private static final ThreadLocal<Integer> THREAD_LOCAL =
            ThreadLocal.withInitial(() -> Integer.valueOf("1"));

    public void business() {

        try{
            Integer i = get();
            System.out.println(Thread.currentThread().getName() + " , i = " + i);
        }
        finally {
            remove();
        }


    }



    public Integer get() {
        return THREAD_LOCAL.get();
    }

    public void remove() {
        THREAD_LOCAL.remove();
    }

}
