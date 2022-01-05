package com.inspire12.algorithm.demo.programers.p42626;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] scoville = new int[] {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        while (!pq.isEmpty()) {
           int first = pq.poll();
            if (first < K) {
                if (pq.isEmpty()) {
                    return -1;
                }
                int second = pq.poll();
                pq.add(first + second * 2);
            } else {
                pq.add(first);
                break;
            }
            answer++;
        }
        return answer;
    }
}
