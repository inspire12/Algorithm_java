package com.inspire12.algorithm.demo.programers.p42586;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        int max = 100;
        Queue<Integer> ww = new LinkedList<>();
        List<Integer> vv = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            ww.add((int)Math.floor((max - progresses[i]) / speeds[i]));
        }
        int prevMin = 100;

        int tmp = 0;
        while(!ww.isEmpty()) {
            int target = ww.remove();
            if (target > prevMin) {
                vv.add(tmp);
                tmp = 0;
                prevMin = 100;
            } else {
                prevMin = target;
            }
            tmp++;
        }
        if (tmp > 0) {
            vv.add(tmp);
        }
        return vv.stream().mapToInt(i -> i).toArray();
    }
}
