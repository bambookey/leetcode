package com.lxy.leetcode;

import com.lxy.common.ListNode;

/**
 * Created by lixiangyu on 2018/10/27.
 */
public class Q021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        head = l1.val < l2.val ? l1 : l2;
        // 每次都有瑕疵，实在让人难受，这个在纸上画画就不会出现这种问题了
        ListNode p = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            } else if (p2 == null) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            } else {
                if (p1.val < p2.val) {
                    p.next = p1;
                    p = p.next;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p = p.next;
                    p2 = p2.next;
                }
            }
        }
        return head;
    }
}
