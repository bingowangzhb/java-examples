package com.bgw.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution002
 *
 * @author zhibin.wang
 * @since 2021/03/24 14:08
 */
public class Solution002 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);  // 4 - 9
        ListNode n2 = new ListNode(9);
        n1.next = n2;

        ListNode m1 = new ListNode(6); //  6

        Solution002 solution = new Solution002();
        ListNode root = solution.addTwoNumbers(n1, m1);
        System.out.println("root = " + root);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1 -> 2 -> 4 -> 4
        // 9 -> 7

        ListNode p1 = l1;
        ListNode p2 = l2;
        int roundVal = 0;
        ListNode h3 = null;
        List<Integer> list = new ArrayList<>();
        while (p1 != null || p2 != null) {
            int val = ((null == p1) ? 0 : p1.val) + ((null == p2) ? 0 : p2.val);
            list.add(val);
            p1 = null == p1 ? null : p1.next;
            p2 = null == p2 ? null : p2.next;
        }

        ListNode root = null;
        ListNode tmp = null;
        int val;
        for (int i = 0; i < list.size() + 1; i++) {
            if (i == 0) {
                root = new ListNode(list.get(0) % 10);
                roundVal = list.get(0) / 10;
                tmp = root;
            }
            else if (i == list.size()) {
                if (roundVal > 0) {
                    ListNode n = new ListNode(1);
                    tmp.next = n;
                    tmp = n;
                }
            }
            else {
                val = (list.get(i) + roundVal) % 10;
                roundVal = (list.get(i) + roundVal) / 10;
                ListNode n = new ListNode(val);
                tmp.next = n;
                tmp = n;
            }
        }
        return root;
    }



    public ListNode add2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }


}

