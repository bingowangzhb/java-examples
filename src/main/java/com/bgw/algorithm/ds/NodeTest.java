package com.bgw.algorithm.ds;
/**
 * NodeTest
 *
 * @author wang
 * @since 2020/8/12 20:07
 **/
public class NodeTest {

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        Node n3 = new Node(3);
        n2.next = n3;
        Node n4 = new Node(4);
        n3.next = n4;
        Node n5 = new Node(5);
        n4.next = n5;
        Node n6 = new Node(6);
        n5.next = n6;
        n6.next = null;

        printLink(n1);
        printLink(reverse(n1));

    }


    public static void printLink(Node h) {
        String content = "";
        Node p = h;
        if (null != p) {
            content += p.data;
            while (null != p.next) {
                content += " -> " + p.next.data;
                p = p.next;
            }
        }
        System.out.println(content);
    }

    public static Node reverse(Node h) {
        Node p, q = null;
        while (null != h) {
            p = h;
            h = h.next;
            p.next = q;
            q = p;
        }

        return q;
    }



}
