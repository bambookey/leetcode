package com.lxy.leetcode;

import java.util.*;

/**
 * 把集合类换成基本类型后，没有发现性能有本质的提升啊
 *
 * Created by lixiangyu on 2018/9/8.
 */
public class Q398 {
    private Random random = new Random();
    int[] n;

    public Q398(int[] nums) {
        n = nums;
    }

    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n.length; i++) {
            if (n[i] == target) {
                list.add(i);
            }
        }

        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
