package com.inspire12.algorithm.solve.programmers.p42627;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// 스케쥴링
// 수행시간이 짧은 작업부터 처리

public class Solution {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                new int[]{0,3},
                new int[]{1,9},
                new int[]{2,6}
        };
        System.out.println(solution(input));
    }

    //ready queue, waiting queue
    public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        PriorityQueue<int[]> waitingPq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        waitingPq.offer(jobs[0]);
        int end = jobs[0][0];
        int sum = 0;
        int index = 1;
        while (! waitingPq.isEmpty()) {
            int[] curWork = waitingPq.poll();
            end += curWork[1];
            sum += end - curWork[0];
            while (index < jobs.length && jobs[index][0] <= end) {
                waitingPq.offer(jobs[index++]);
            }
            while (index < jobs.length && waitingPq.isEmpty()) {
                end = jobs[index][0];
                waitingPq.offer(jobs[index++]);
            }
        }

        return sum / jobs.length;
    }
}