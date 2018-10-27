package com.lxy.leetcode;

import java.util.Stack;

/**
 *
 *
 * Created by lixiangyu on 2018/10/27.
 */
public class Q020 {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid(""));
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                // pop的时候一定记得判断栈是否空
                if(stack.empty()) {
                    return false;
                }
                char cc = stack.pop();
                if(cc !='[') {
                    return false;
                }
            } else if (c == '}') {
                if(stack.empty()) {
                    return false;
                }
                char cc = stack.pop();
                if(cc !='{') {
                    return false;
                }
            } else if (c == ')') {
                if(stack.empty()) {
                    return false;
                }
                char cc = stack.pop();
                if(cc !='(') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        /**
         * 注意这里的条件是栈空而不是执行到此就可以认为是成功
         */
        return stack.empty();
    }
}
