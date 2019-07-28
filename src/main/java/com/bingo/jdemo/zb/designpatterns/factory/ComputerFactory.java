package com.bingo.jdemo.zb.designpatterns.factory;

import com.bingo.jdemo.zb.designpatterns.factory.model.AbstractComputer;
import com.bingo.jdemo.zb.designpatterns.factory.model.PC;
import com.bingo.jdemo.zb.designpatterns.factory.model.Server;

/**
 * 说明：
 *
 * @author ShujuboDev
 */
public class ComputerFactory {
    public static AbstractComputer getComputer(String type, String cpu, String ram, String hdd) {
        if ("PC".equalsIgnoreCase(type)) {
            return new PC(cpu, ram, hdd);
        }
        else if ("Server".equalsIgnoreCase(type)) {
            return new Server(cpu, ram, hdd);
        }

        return null;

    }
}
