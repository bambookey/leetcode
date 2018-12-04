package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/12/5.
 */
public class Q069 {
    public static void main(String[] args) {
        Q069 q = new Q069();
        System.out.println(q.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x <= 1) return x;

        int low = 1, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (x / mid == mid) return mid;
            else if (x / mid > mid) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }

    public int mySqrt2(int x) {
        long i;
        for (i = 1; ; i *= 2) {
            if (i * i >= x) {
                break;
            }
        }
        while (true) {
            if (i * i <= x) {
                break;
            }
            i--;
        }
        return (int) i;
    }
}
