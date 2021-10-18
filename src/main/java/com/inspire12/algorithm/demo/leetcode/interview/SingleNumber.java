package com.inspire12.algorithm.demo.leetcode.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        removeDuplicates(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static int removeDuplicates(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>(((o1, o2) -> o2 - o1));
        for (int num : nums) {
            set.add(num);
        }
        int i = 0;
        for(int num : set.descendingSet()) {
            nums[i] = num;
            i++;
        }

        return set.size();
    }
}
