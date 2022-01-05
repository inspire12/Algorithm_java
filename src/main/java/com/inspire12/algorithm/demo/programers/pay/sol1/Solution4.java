package com.inspire12.algorithm.demo.programers.pay.sol1;

public class Solution4 {
    public static void main(String[] args) {
    }

    class Solution {
        public int solution(int[][] board) {
            int N = board.length;
            int[][][] cached = new int[N][N][2];

            cached[0][0][0] = board[0][0]; // max
            cached[0][0][1] = board[0][0]; // min

            for (int i = 1; i < N; i++) {
                cached[i][0][0] = board[i][0] + cached[i - 1][0][0];
                cached[i][0][1] = board[i][0] + cached[i - 1][0][1];

                cached[0][i][0] = board[0][i] + cached[0][i - 1][0];
                cached[0][i][1] = board[0][i] + cached[0][i - 1][1];
            }

            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    cached[i][j][0] = Math.max(cached[i - 1][j][0], cached[i][j - 1][0]) + board[i - 1][j - 1];
                    cached[i][j][1] = Math.min(cached[i - 1][j][0], cached[i][j - 1][0]) + board[i - 1][j - 1];
                    if (board[i][j] == 0) {
                        cached[i][j][0] = Math.max(cached[i][j][0], cached[i][j][1] * -1);
                    }
                }
            }
            return cached[N-1][N-1][0];
            // 0을 거치는 경우
            // 0을 안 거치는 경우
        }
    }
}
