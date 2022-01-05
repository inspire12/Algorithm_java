package com.inspire12.algorithm.demo.interview.coupang;

public class P3 {
    // 점들을 가장 길게 연결

    private final int[][] dist = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int solution(int[][] board) {
        int answer = -1;
        for (int x = 0; x < board.length; x++) {

            for (int y = 0; y < board[0].length; y++) {
                boolean[][] visit = new boolean[5][5];
                int tmp = getMaxPath(board, x, y, visit);
                answer = Math.max(answer, tmp);
            }
        }
        if (answer == 1) {
            return -1;
        }
        return answer;
    }

    public int getMaxPath(int[][] board, int x, int y, boolean[][] visit) {
        visit[x][y] = true;
        for (int i=0; i < dist.length; i++) {
            int nextX = x + dist[i][0];
            int nextY = y + dist[i][1];

            if (nextX >= board.length || nextY >= board[0].length || nextX < 0 || nextY < 0) {
                continue;
            }

            int nextDot = board[nextX][nextY];

            if (board[x][y] == nextDot && !visit[nextX][nextY]) {
                int path = getMaxPath(board, nextX, nextY, visit) + 1;
                System.out.println(String.format("%d %d %d", path, nextX, nextY));
                return path;
            }
        }
        return 1;
    }
}
