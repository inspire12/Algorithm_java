package com.inspire12.algorithm.solve.programmers.p42747;

//H-index
// n  h > i h의 최댓값

import org.springframework.util.comparator.Comparators;

import java.util.Arrays;
import java.util.Collections;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

        int a = solution(new int[]{10, 8, 5, 4, 3});
        System.out.println(a);

    }

    public static int solution(int[] citations) {

        int[] sortedCitations = Arrays.stream(citations)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(i -> i)
                .toArray();
        for (int i = 0; i < sortedCitations.length; i++) {
            if (sortedCitations[i] <= i+1) {
                return sortedCitations[i];
            }
        }
        return sortedCitations[sortedCitations.length - 1];
    }
}
