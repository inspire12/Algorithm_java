package com.inspire12.algorithm.demo.programers.p42840;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] answers = new int[]{0};
        for (int i : new Solution().solution(answers)) {
            System.out.print(i);
        }
    }
    public int[] solution(int[] answers) {

        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] scores = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            int k = answers[i];
            for (int j = 0; j < 3; j++) {
                if (k == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }


        int[] arr = new int[scores.length];
        for(int i = 0; i < scores.length; i++){
            arr[i] = scores[i];
        }

        Arrays.sort(arr);

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            if(scores[i] == arr[2]){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}