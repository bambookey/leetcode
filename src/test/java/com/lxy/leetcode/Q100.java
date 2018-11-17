package com.lxy.leetcode;


import com.lxy.common.TreeNode;

/**
 * Created by lixiangyu on 2018/11/17.
 */
public class Q100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(null == p && null == q) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}
