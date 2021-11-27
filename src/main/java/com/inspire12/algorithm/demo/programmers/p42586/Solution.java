package com.inspire12.algorithm.demo.programmers.p42586;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int max = 100;
        Queue<Integer> workDays = new LinkedList<>();
        List<Integer> deployCount = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            workDays.add((int)Math.ceil((double)(max - progresses[i]) / (double)speeds[i]));
        }
        int prevMax = workDays.peek();

        int tmp = 0;
        while(!workDays.isEmpty()) {
            int target = workDays.remove();
            if (target > prevMax) {
                prevMax = target;
                deployCount.add(tmp);
                tmp = 0;
            }
            tmp++;
        }
        if (tmp > 0) {
            deployCount.add(tmp);
        }
        return deployCount.stream().mapToInt(i -> i).toArray();
    }
}
