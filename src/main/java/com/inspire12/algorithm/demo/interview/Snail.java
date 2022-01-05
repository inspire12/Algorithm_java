package com.inspire12.algorithm.demo.interview;

import java.util.Arrays;

public class Snail {
    /**
     * 아이디어: 4개 방향을 패턴으로 반복
     */
    public static void main(String[] args) {
        int n = 5;
        int k = 35;
        int[][] answer = new int[][]{
                new int[]{1, 2, 3, 4, 5},
                new int[]{16, 17, 18, 19, 6},
                new int[]{15, 24, 25, 20, 7},
                new int[]{14, 23, 22, 21, 8},
                new int[]{13, 12, 11, 10, 9},
        };

        int[][] result = solution(n, 35);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[j][i]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] solution(int N, int K) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] result = new int[N + 2][N + 2];
        int i = 0;
        int j = 0;
        int right = N;
        int left = 0;
        int direction = 0;

        for (int index = 1; index <= N * N; index++) {
            result[i][j] = index;
            i += dx[direction];
            j += dy[direction];

            if ((i >= right - 1) && direction == 0) {
                direction = (direction + 1) % 4;
                System.out.println(Arrays.deepToString(result));
            } else if ((i <= left) && direction == 2) {
                direction = (direction + 1) % 4;
                left += 1;
                System.out.println(Arrays.deepToString(result));
            } else if ((j >= right - 1) && direction == 1) {
                direction = (direction + 1) % 4;
                System.out.println(Arrays.deepToString(result));
            } else if ((j <= left) && direction == 3) {
                direction = (direction + 1) % 4;
                right -= 1;
                System.out.println(Arrays.deepToString(result));
            }
        }
        return result;
    }
}
