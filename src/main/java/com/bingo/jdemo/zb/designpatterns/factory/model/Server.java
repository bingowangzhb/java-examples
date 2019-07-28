package com.zb.designpatterns.factory.model;

/**
 * 说明：
 *
 * @author ShujuboDev
 */
public class Server extends AbstractComputer {

    private String cpu;
    private String ram;
    private String hdd;


    public Server(String cpu, String ram, String hdd) {
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
