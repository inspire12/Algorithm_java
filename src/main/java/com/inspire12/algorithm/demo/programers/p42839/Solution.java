package com.inspire12.algorithm.demo.programers.p42839;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private static List<Boolean> visits;
    private static List<String> list;
    private static Set<String> candidates;
    private static Set<Integer> answers;

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        visits = new ArrayList<>();
        candidates = new HashSet<>();
        list = new ArrayList<>();
        answers = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            visits.add(false);
            list.add(String.valueOf(numbers.charAt(i)));
        }
        dfs("", 0);

        System.out.println(candidates);
        for (String candidate : candidates) {
            if (isPrime(Integer.parseInt(candidate))) {
                answers.add(Integer.parseInt(candidate));
            }
        }
        return answers.size();
    }

    public static void dfs(String number, int depth) {
        for (int i = 0; i < list.size(); i++) {
            if (visits.get(i)) continue;
            visits.set(i, true);
            dfs(number + list.get(i),depth + 1);
            visits.set(i, false);
            candidates.add(number + list.get(i));
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1 || n == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
