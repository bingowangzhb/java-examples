package com.bgw.zb.designpatterns.factory.model;

/**
 * 说明：
 *
 * @author ShujuboDev
 */
public abstract class AbstractComputer {
    public abstract String getCpu();

    public abstract String getRam();

    public abstract String getHdd();

    @Override
    public String toString() {
        return "CPU=" + getCpu() + ", RAM=" + getRam() + ", HDD=" + getHdd();
    }
}
