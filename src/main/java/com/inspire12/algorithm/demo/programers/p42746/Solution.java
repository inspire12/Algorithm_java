package com.inspire12.algorithm.demo.programers.p42746;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        int[] numbers = new int[]{0,0,0,0,0};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {

        String answer = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2))
                .collect(Collectors.joining());

        if (answer.charAt(0)=='0') {
            return "0";
        }
        return answer;
    }
}