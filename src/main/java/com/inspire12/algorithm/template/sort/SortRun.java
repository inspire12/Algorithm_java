package com.inspire12.algorithm.template.sort;

import java.util.Arrays;
import java.util.List;

public class SortRun {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        List<Integer> arr = Arrays.asList(9,4,2,3,1,5,7,6,8,0);
        List<Integer> sortedArr = mergeSort.sort(arr);

        System.out.println(sortedArr);
    }
}
