package com.bgw.juc.threadpool;

/**
 * ThreadPoolTest
 *
 * @author wang
 * @since 2021/3/23 20:58
 **/
public class ThreadPoolTest {
    // COUNT_BITS = 29
    private static final int COUNT_BITS = Integer.SIZE - 3;
    // 2的29次方-1
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    private static final int CAPACITY2   = (1 << COUNT_BITS);

    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    public static void main(String[] args) {
        System.out.println("CAPACITY = " + CAPACITY);
        //
        // CAPACITY : 000 1 1111 1111 1111 1111 1111 1111 1111
        System.out.println("CAPACITY = " + Integer.toBinaryString(CAPACITY));
        System.out.println("~CAPACITY= " + Integer.toBinaryString(~CAPACITY));
        System.out.println("CAPACITY2= " + Integer.toBinaryString(CAPACITY2));
        System.out.println("RUNNING = " + Integer.toBinaryString(RUNNING));
        System.out.println("SHUTDOWN = " + SHUTDOWN);
        System.out.println("STOP = " + STOP);
        System.out.println("TIDYING = " + TIDYING);

        System.out.println("(-1 << 1) = " + (-1 << 3));

        System.out.println("Integer.toBinaryString(-1) = " + Integer.toBinaryString(-1));
        System.out.println("Integer.toBinaryString((-1 << 1)) = " + Integer.toBinaryString((-1 << 1)));
        System.out.println("Integer.toBinaryString((-1 << 2)) = " + Integer.toBinaryString((-1 << 2)));
        System.out.println("Integer.toBinaryString((-1 << 3)) = " + Integer.toBinaryString((-1 << 3)));
        System.out.println("Integer.toBinaryString((-1 << 31)) = " + Integer.toBinaryString((-1 << 31)));
        System.out.println("Integer.toBinaryString((-1 << 31)) = " + Integer.toBinaryString((-1 << 32)));

        System.out.println("ctlOf(RUNNING, 0) = " + ctlOf(RUNNING, 0));
    }

    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }
}
