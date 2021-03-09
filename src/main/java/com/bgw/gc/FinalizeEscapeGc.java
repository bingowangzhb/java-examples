package com.bgw.gc;

import java.util.concurrent.TimeUnit;

/**
 * FinalizeEscapeGc
 *
 * @author zhibin.wang
 * @since 2021/03/05 11:23
 */
public class FinalizeEscapeGc {

    public static FinalizeEscapeGc SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive");
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize() is executed! ");

        FinalizeEscapeGc.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Exception {
        SAVE_HOOK = new FinalizeEscapeGc();

        SAVE_HOOK = null;

        System.gc();
        TimeUnit.SECONDS.sleep(1);

        if (null != SAVE_HOOK) {
            SAVE_HOOK.isAlive();
        }
        else {
            System.out.println("no, i am dead!");
        }


        SAVE_HOOK = null;

        System.gc();
        TimeUnit.SECONDS.sleep(1);
        if (null != SAVE_HOOK) {
            SAVE_HOOK.isAlive();
        }
        else {
            System.out.println("no, i am dead!");
        }
    }
}
