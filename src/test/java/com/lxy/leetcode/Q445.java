package com.lxy.leetcode;

import com.lxy.common.ListNode;

import java.util.Arrays;

/**
 * Created by lixiangyu on 2018/9/10.
 */
public class Q445 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        addTwoNumbers( l1,  l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 1;
        int len2 = 1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1.next != null) {
            p1 = p1.next;
            len1++;
        }
        while (p2.next != null) {
            p2 = p2.next;
            len2++;
        }
        int maxLen = Math.max(len1, len2);
        int[] n1 = new int[maxLen + 1];
        int[] n2 = new int[maxLen + 1];


        p1 = l1;
        p2 = l2;
        for (int i = 0; i < maxLen + 1; i++) {
            if (i > maxLen - len1) {
                n1[i] = p1.val;
                p1 = p1.next;
            }
            if (i > maxLen - len2) {
                n2[i] = p2.val;
                p2 = p2.next;
            }
        }

        int add = 0;
        int[] re = new int[maxLen + 1];
        for (int i = maxLen; i >= 0; i--) {
            int tmp = n1[i] + n2[i] + add;
            re[i] = tmp % 10;
            add = tmp / 10;
        }

        ListNode node = null;
        ListNode p = null;
        boolean first = false;
        for (int i = 0; i < maxLen + 1; i++) {
            if (!first) {
                if (re[i] == 0) {
                    continue;
                } else {
                    first = true;
                    node = new ListNode(re[i]);
                    p = node;
                }
            } else {
                p.next = new ListNode(re[i]);
                p = p.next;
            }
        }
        if (node == null) {
            return new ListNode(0);
        }
        return node;
    }
}
