package com.bgw.common.pool2.sample1;

import org.apache.commons.pool2.impl.GenericObjectPool;

import java.io.FileReader;
import java.io.Reader;

public class PooledReadUtilTest {
    public static void main(String[] args) {
        StringBufferFactory factory = new StringBufferFactory();
        GenericObjectPool<StringBuffer> objectPool = new GenericObjectPool<>(factory);
        PooledReadUtil readUtil = new PooledReadUtil(objectPool);


        try {
            Reader reader = new FileReader("d:\\a.txt");

            String s = readUtil.readToString(reader);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
