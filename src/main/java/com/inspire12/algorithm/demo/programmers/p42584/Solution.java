package com.inspire12.algorithm.demo.programmers.p42584;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> pricesQueue = new LinkedList<>();

        for (int price : prices) {
            pricesQueue.offer(price);
        }

        for (int price ; !pricesQueue.isEmpty(); price = pricesQueue.poll()) {

        }
        return null;
    }
}
