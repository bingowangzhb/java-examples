package com.bgw.common.pool2.sample1;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.DestroyMode;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class StringBufferFactory extends BasePooledObjectFactory<StringBuffer> {

    @Override
    public StringBuffer create() throws Exception {
        return new StringBuffer();
    }

    @Override
    public PooledObject<StringBuffer> wrap(StringBuffer buf) {
        return new DefaultPooledObject<>(buf);
    }

    @Override
    public void destroyObject(PooledObject<StringBuffer> pooledObject, DestroyMode mode) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject<StringBuffer> pooledObject) throws Exception {
        pooledObject.getObject().setLength(0);
    }
}
