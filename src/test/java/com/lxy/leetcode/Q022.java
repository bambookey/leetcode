package com.lxy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 思路是递归，但是还是参考了一下网上的题解
 * <p>
 * 符合括号规则的，任意一个位置左侧的"("数量要大雨右侧的")"数量
 * 根据这个递归条件就能够写出很漂亮的代码了
 * <p>
 * Created by lixiangyu on 2018/10/27.
 */
public class Q022 {
    public static void main(String[] args) {
        Q022 q = new Q022();
        System.out.println(q.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(n, n, "", result);
        return result;
    }

    public void solve(int l, int r, String s, List<String> result) {
        if (l == 0 && r == 0) {
            result.add(s);
        }
        if (l > 0) {
            solve(l - 1, r, s + "(", result);
        }
        if (r > 0 && l < r) {
            solve(l, r - 1, s + ")", result);
        }
    }
}
