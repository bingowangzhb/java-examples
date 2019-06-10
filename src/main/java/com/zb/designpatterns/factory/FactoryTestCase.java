package com.zb.designpatterns.factory;

import com.zb.designpatterns.factory.model.AbstractComputer;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/8/7 17:03
 */
public class FactoryTestCase {
    public static void main(String[] args) {
        AbstractComputer pc = ComputerFactory.getComputer("pc", "intel-8400", "hdc-16G", "sumsang-256G");
        AbstractComputer server = ComputerFactory.getComputer("server", "intel-8700k", "hdc-64G", "sumsang-1T");

        System.out.println(pc);
        System.out.println(server);
    }
}
