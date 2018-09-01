package com.lxy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lixiangyu on 2018/9/1.
 */
public class Q380 {
    public static void main(String[] args) {

    }

    /** Initialize your data structure here. */
}

class RandomizedSet {
    private Set<Integer> set = new HashSet<>();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val)) {
            return false;
        } else {
            set.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.contains(val)) {
            set.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = (int) (set.size() * Math.random());
        return (int) set.toArray()[randomIndex];
    }
}
