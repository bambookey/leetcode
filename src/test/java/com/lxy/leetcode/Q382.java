package com.lxy.leetcode;

import com.lxy.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiangyu on 2018/9/1.
 */
public class Q382 {

    private ArrayList<Integer> cache;

    public Q382(ListNode head) {
        cache = new ArrayList<>();
        ListNode node = head;
        while (true) {
            cache.add(node.val);
            if (node.next == null) {
                return;
            }
            node = node.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int randomIndex = (int) (Math.random() * cache.size());
        return cache.get(randomIndex);
    }
}
