package com.bingo.jdemo.zb.designpatterns.factory.model;

/**
 * 说明：
 *
 * @author ShujuboDev
 */
public class PC extends AbstractComputer {

    private String cpu;
    private String ram;
    private String hdd;


    public PC(String cpu, String ram, String hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    public String getCpu() {
        return this.cpu;
    }

    public String getRam() {
        return this.ram;
    }

    public String getHdd() {
        return this.hdd;
    }
}
