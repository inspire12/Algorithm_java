package com.inspire12.algorithm.demo.programers.p42748;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] ans = solution(new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{new int[]{2, 5, 3}, new int[]{4, 4, 1}, new int[]{1, 7, 3}});
        Arrays.stream(ans).forEach(System.out::println);
    }

    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> ans = new ArrayList<>();
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            List<Integer> arr = Arrays.stream(array)
                    .boxed()
                    .collect(Collectors.toList());
            List<Integer> subList = arr.subList(i - 1, j);
            subList.sort(Comparator.comparingInt(o -> o));
            ans.add(subList.get(k - 1));
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
