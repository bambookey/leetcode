package com.lxy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lixiangyu on 2018/11/5.
 */
public class Q088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num[] = new int[m + n];
        int p = 0;
        int pm = 0;
        int pn = 0;
        while (true) {
            if (pm < m && pn < n) {
                int n1 = nums1[pm];
                int n2 = nums2[pn];
                if (n1 > n2) {
                    num[p++] = n2;
                    pn++;
                } else {
                    num[p++] = n1;
                    pm++;
                }
            } else if (pm < m) {
                int n1 = nums1[pm];
                num[p++] = n1;
                pm++;
            } else if (pn < n) {
                int n2 = nums2[pn];
                num[p++] = n2;
                pn++;
            } else {
                break;
            }
        }
        System.arraycopy(num, 0, nums1, 0, nums1.length);

    }
}
