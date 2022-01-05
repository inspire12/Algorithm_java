package com.inspire12.algorithm.demo.programmers;

import com.inspire12.algorithm.demo.programmers.p42583.Solution;

public class ProgrammersRun {
    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] progresses = new int[] {3,2,1};
//        int[] speeds = new int[] {1,1,1};
//        int[] result = s.solution(progresses, speeds);
//        for (int r : result) {
//            System.out.print(r + " ");
//        }
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = new int[]{10,10,10,10,10,10,10,10,10,10};
        Solution s = new Solution();
        System.out.println(s.solution(bridge_length, weight, truck_weights));
    }
}
