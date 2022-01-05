package com.inspire12.algorithm.demo.programers.p42584;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                ans[stack.peek()] = 1 - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            ans[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        return ans;
    }
}
