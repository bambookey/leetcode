package com.lxy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiangyu on 2018/9/1.
 */
public class Q386 {
    public static void main(String[] args) {
        System.out.println("+" + lexicalOrder(33));
    }

    //[1,10,100....100000,11,12,13...19,2,20,3,4,5,6,7,8,9].
    // 199,2
    public static List<Integer> lexicalOrder(int n) {

        List<Integer> arr = new ArrayList<>();
        int num = 1;
        for (int i = 1; i <= n; i++) {
            arr.add(num);
            if (num * 10 <= n) {
                num = num * 10;
                continue;
            }
            if (num % 10 != 9 && num + 1 <= n) {
                num++;
            } else {
                while ((num / 10) % 10 == 9) {
                    num = num / 10;
                }
                num = num / 10 + 1;
            }
        }
        return arr;
    }
}
