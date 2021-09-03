package com.bgw.common.pool2.sample2;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.net.InetSocketAddress;
import java.net.Socket;

public class ConnectionFactory extends BasePooledObjectFactory<Socket> {

    private final InetSocketAddress address;

    public ConnectionFactory(String ip, int port) {
        this.address = new InetSocketAddress(ip, port);
    }

    @Override
    public Socket create() throws Exception {
        Socket socket = new Socket();
        socket.connect(address);
        return socket;
    }

    @Override
    public PooledObject<Socket> wrap(Socket socket) {
        return new DefaultPooledObject<>(socket);
    }

    @Override
    public void destroyObject(PooledObject<Socket> pooledObject) throws Exception {
        pooledObject.getObject().close();
    }

    @Override
    public boolean validateObject(PooledObject<Socket> pooledObject) {
        Socket socket = pooledObject.getObject();
        if (!socket.isConnected()) {
            return false;
        }
        if (socket.isClosed()) {
            return false;
        }
        return true;
    }
}
