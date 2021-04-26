package com.bgw.algorithm;

/**
 * ListNode
 *
 * @author zhibin.wang
 * @since 2021/03/31 11:08
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}