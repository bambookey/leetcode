package com.lxy.leetcode;

import com.lxy.common.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lixiangyu on 2018/11/25.
 */
public class Q056 {
    public List<Interval> merge(List<Interval> intervals) {
        if (null == intervals || 0 == intervals.size()) {
            return intervals;
        }
        // 使用jdk8的排序代码精简好多
        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        List<Interval> mergeList = new ArrayList<>();
        Interval itv = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (itv.end >= interval.end) {
                continue;
            } else if (itv.end < interval.start) {
                mergeList.add(itv);
                itv = new Interval(interval.start, interval.end);
            } else {
                itv.end = interval.end;
            }
        }
        mergeList.add(itv);


        return mergeList;
    }
}
