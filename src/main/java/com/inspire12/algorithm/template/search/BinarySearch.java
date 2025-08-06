package com.inspire12.algorithm.template.search;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(run(Arrays.asList(1,2,3,4,5), 6));
    }
    public static int run(List<Integer> sortedList, int value) {

        int left = 0;
        int right = sortedList.size() - 1;

        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (sortedList.get(pivot) > value) {
                right = pivot - 1;
            } else if (sortedList.get(pivot) < value) {
                left = pivot + 1;
            } else if (sortedList.get(pivot) == value) {
                return value;
            }
        }

        return -1;
    }
}
