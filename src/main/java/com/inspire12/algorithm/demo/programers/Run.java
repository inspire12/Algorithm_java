package com.inspire12.algorithm.demo.programers;

import java.util.HashMap;
import java.util.Map;

public class Run {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{new int[]{1,1} ,new int[]{2,2},new int[]{1,2}})[0]);
    }
    public static int[] solution(int[][] v) {
        int[] answer = new int[2];
        Map<Integer, Integer> xmap = new HashMap<>();
        Map<Integer, Integer> ymap = new HashMap<>();
        for (int[] dot : v) {
            int x = dot[0];
            int y = dot[1];
            xmap.put(x, xmap.getOrDefault(x, 0) + 1);
            ymap.put(y, ymap.getOrDefault(y, 0) + 1);
        }

        xmap.forEach((integer, integer2) -> {
            if (integer2 == 1) {
                answer[0] = integer;
            }
        });
        ymap.forEach((integer, integer2) -> {
            if (integer2 == 1) {
                answer[1] = integer;
            }
        });

        return answer;
    }
}
