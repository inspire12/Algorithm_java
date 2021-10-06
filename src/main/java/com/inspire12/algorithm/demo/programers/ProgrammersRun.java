package com.inspire12.algorithm.demo.programers;

import com.inspire12.algorithm.demo.programers.p42584.Solution;

import java.util.Arrays;

public class ProgrammersRun {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 2, 3};
        Solution solution = new Solution();
        int[] a = solution.solution(prices);
        for(int b: a) {
            System.out.print(b + " ");
        }
//        System.out.println(a);
    }
}
