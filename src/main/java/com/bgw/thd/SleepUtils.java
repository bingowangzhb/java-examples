package com.bgw.thd;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

/**
 * SleepUtils
 *
 * @author zhibin.wang
 * @since 2020/09/08 16:43
 */
public class SleepUtils {

    public static void sleep(TimeUnit timeUnit, long timeout) {
        try {
            timeUnit.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(long timeout) {
        sleep(TimeUnit.MICROSECONDS, timeout);
    }
}
