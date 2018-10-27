package com.lxy.leetcode;

import com.lxy.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 这道题不算A，用的手法实在是。。。。
 *
 * Created by lixiangyu on 2018/10/27.
 */
public class Q023 {

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nums = new ArrayList<>();
        for(ListNode list : lists) {
            while(list != null) {
                nums.add(list.val);
                list = list.next;
            }
        }
        ListNode result = new ListNode(-1);
        ListNode p = result;
        Collections.sort(nums);
        for(int x : nums) {
            p.next = new ListNode(x);
            p = p.next;
        }
        return result.next;
    }
}
