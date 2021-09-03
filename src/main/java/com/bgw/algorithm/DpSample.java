package com.bgw.algorithm;

import java.math.BigInteger;

/**
 * @author ambow
 * @since 2021/7/5 16:51
 */
public class DpSample {


    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }


    public BigInteger fib2(int n) {
        BigInteger[] results = new BigInteger[n + 1];

        for (int i = 0; i < n + 1; i++) {
            if (i < 2) {
                results[i] = new BigInteger(Integer.toString(i));
            }
            else {
                results[i] = results[i-1].add(results[i-2]);
            }
        }

        return results[n];

    }


    public static void main(String[] args) {
        DpSample sample = new DpSample();
        BigInteger result = sample.fib2(100);
        System.out.println("result = " + result);

    }

}
