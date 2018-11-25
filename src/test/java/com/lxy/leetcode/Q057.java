package com.lxy.leetcode;

import com.lxy.common.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiangyu on 2018/11/25.
 */
public class Q057 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i));
            i++;
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        res.add(newInterval);

        while (i < intervals.size() && intervals.get(i).start > newInterval.end) {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }
}
