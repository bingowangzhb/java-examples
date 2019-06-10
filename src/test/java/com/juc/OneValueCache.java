package com.juc;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/11/6 14:49
 */
public class OneValueCache {
    private final BigInteger lastNumber;

    public OneValueCache(BigInteger lastNumber) {
        this.lastNumber = lastNumber;
    }


    public static void main(String[] args) {

    }

    public void setValue() {
        List<String> unsafeList = Lists.newArrayList();
        List<String> safeList = Collections.synchronizedList(unsafeList);


        Map<String, String> unsafeMap = Maps.newHashMap();
        Map<String, String> safeMap = Collections.unmodifiableMap(unsafeMap);

        Vector v;
    }
}
