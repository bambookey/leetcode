package com.lxy.leetcode;

import com.lxy.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 理论上应当有快慢指针的做法
 * Created by lixiangyu on 2018/12/13.
 */
public class Q142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                return head;
            }
            visited.add(head);
            head = head.next;
        }
        return null;
    }
}
