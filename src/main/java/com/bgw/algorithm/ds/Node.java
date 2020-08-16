package com.bgw.algorithm.ds;

/**
 * Node
 *
 * @author wang
 * @since 2020/8/12 20:06
 **/
public class Node {
    public Node next;
    public int data;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
