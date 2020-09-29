package com.bgw.basic.sample5;

/**
 * AbsSynchronizer
 *
 * @author zhibin.wang
 * @since 2020/09/29 13:56
 */
public abstract class AbsSynchronizer {

    private volatile int state;

    protected final int getState() {
        return state;
    }

    protected final void setState(int state) {
        this.state = state;
    }
}
