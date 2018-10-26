package com.lxy.leetcode;

import com.lxy.common.ListNode;

/**
 * Created by lixiangyu on 2018/10/26.
 */
public class Q019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = head;
        ListNode end = head;

        for(int i = 0; i < n;i++) {
            end = end.next;
        }

        if (end == null) {
            head = head.next;
            return head;
        }

        while(true) {
            if(end.next == null) {
                break;
            }
            start = start.next;
            end = end.next;
        }

        start.next = start.next.next;

        return head;
    }
}
