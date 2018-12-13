package com.lxy.leetcode;

import com.lxy.common.ListNode;

import java.util.Arrays;

/**
 * 经验就是数组比list效率高太多了
 *
 * Created by lixiangyu on 2018/12/13.
 */
public class Q148 {
    public ListNode sortList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode p = head;
        int len = 0;
        while (null != p) {
            len++;
            p = p.next;
        }

        int[] arr = new int[len];
        p = head;
        int i = 0;
        while (null != p) {
            arr[i++] = p.val;
            p = p.next;
        }

        Arrays.sort(arr);

        p = head;
        i = 0;
        while (null != p) {
            p.val = arr[i++];
            p=p.next;
        }
        return head;
    }
}
