package com.lxy.leetcode;

import java.util.Stack;

/**
 * Created by lixiangyu on 2018/9/4.
 */
public class Q394 {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[b4[F]c]"));
    }
    public static String decodeString(String s) {
        Stack<Integer> kstack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String str = "";
        int k = 0;

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                k = k * 10 + (c-'0');
            }
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                str = str + c;
            }
            if (c == '[') {
                if(str.length() != 0) {
                    strStack.push(str);
                    str = "";
                }
                kstack.push(k);
                k = 0;
            }
            if (c == ']') {
                int kk = kstack.pop();
                String tmp = "";
                for(int j = 0 ; j < kk; j++) {
                    tmp += str;
                }
                if(kstack.size() == 0) {
                    result = result + tmp;
                } else {
                    str = strStack.pop() + tmp;
                }
            }
        }

        if(str.length() != 0) {
            result = result + str;
        }
        return result;
    }
}
