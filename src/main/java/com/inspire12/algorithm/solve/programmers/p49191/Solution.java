package com.inspire12.algorithm.solve.programmers.p49191;

public class Solution {
    public static void main(String[] args) {
        int[][] input = {
                {4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
        };

        System.out.println(2 == solution(5, input));

    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        String a = "1,2,3,4";
        long commaCount = a.chars().filter(ch -> ch == ',').count();

        System.out.println(commaCount);


        int [] inputs = new int[n+1];

        int[] count = new int[n+1];

        return answer;
    }

}
