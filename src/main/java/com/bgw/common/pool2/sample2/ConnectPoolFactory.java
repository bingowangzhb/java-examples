package com.bgw.common.pool2.sample2;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import java.net.Socket;

public class ConnectPoolFactory {

    private final ObjectPool<Socket> pool;

    public ConnectPoolFactory(String ip, int port) {
        ConnectionFactory factory = new ConnectionFactory(ip, port);
        this.pool = new GenericObjectPool<>(factory);
    }
}
