package com.inspire12.algorithm.demo.algorithm.greedy;

import java.util.Arrays;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {
        int N = 4;
        int K = 7;
        List<Stone> stones = Arrays.asList(
                new Stone(6, 13),
                new Stone(4, 8),
                new Stone(3, 6),
                new Stone(5, 12)
        );
        stones.sort((o1, o2) -> o2.v - o1.v);

        int r = dfs(stones, 0, 0, 0, N, K);
        int result = 14;
        stones.sort((o1, o2) -> o1.v - o2.v);
        int r2 = dp(stones, N, K);
        System.out.println(r);
        System.out.println(r2);
    }

    public static int dfs(List<Stone> stones, int weight, int stoneIndex, int value, int N, int K) {
        if (N <= stoneIndex) {
            return value;
        }
        int maxValue = value;
        Stone stone = stones.get(stoneIndex);
        if (weight + stone.w <= K) { // 물건 포함할 경우
            maxValue = Math.max(dfs(stones, weight + stone.w, stoneIndex + 1, value + stone.v, N, K), maxValue);
        }
        if (weight <= K) { // 물건 미포함
            maxValue = Math.max(dfs(stones, weight, stoneIndex + 1, value, N, K), maxValue);
        }
        return maxValue;
    }

    public static int dp(List<Stone> stones, int N, int K) {
        int[][] cache = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int weight = 1; weight <= K; weight++) {
                if (weight - stones.get(i - 1).w < 0) { // 물건을 넣을 수 있는 경우
                    cache[i][weight] = cache[i - 1][weight];
                } else { // 물건을 넣을수 없는 경우
                    cache[i][weight] = Math.max(cache[i - 1][weight], cache[i - 1][weight - stones.get(i - 1).w] + stones.get(i - 1).v);
                }
            }
        }
        return cache[N][K];
    }


    public static class Stone {
        int w;
        int v;

        public Stone(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
