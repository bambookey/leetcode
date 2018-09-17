package com.lxy.leetcode;

import com.lxy.common.ListNode;

/**
 * Created by lixiangyu on 2018/9/17.
 */
public class Q002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode p = ret;
        int add = 0;
        while (true) {
            if (l1 == null && l2 == null) {
                if(add != 0) {
                    p.next = new ListNode(add);
                }
                break;
            }
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }

            int n1 = l1.val;
            int n2 = l2.val;
            int val = (n1 + n2 + add) % 10;
            add = (n1 + n2 + add) / 10;

            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        return ret.next;
    }
}
