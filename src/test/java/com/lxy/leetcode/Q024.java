package com.lxy.leetcode;

import com.lxy.common.ListNode;

/**
 * Created by lixiangyu on 2018/10/28.
 */
public class Q024 {
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        doSwap(node, head);
        return node.next;
    }

    private void doSwap(ListNode pre, ListNode n1) {
        if(null != n1 && null == n1.next) {
            pre.next = n1;
        }
        if (null != n1 && null != n1.next) {
            pre.next = n1.next;
            ListNode next = n1.next.next;
            n1.next.next = n1;
            // 两次AC的，最开始这里没有考虑到，其实在纸上画一画，就没有问题的，这种题只要思路清晰就不会错
            n1.next = null;
            doSwap(n1, next);
        }
    }
}
