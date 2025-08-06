package com.inspire12.algorithm.solve.programmers.pccp;

import java.util.LinkedList;
import java.util.Queue;

public class P250134 {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public int solution(int[][] maze) {
        int R = maze.length;
        int C = maze[0].length;

        int rx = 0, ry = 0, bx = 0, by = 0, rex = 0, rey = 0, bex = 0, bey = 0;

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++) {
                if (maze[i][j] == 1) { rx = i; ry = j; }
                if (maze[i][j] == 2) { bx = i; by = j; }
                if (maze[i][j] == 3) { rex = i; rey = j; }
                if (maze[i][j] == 4) { bex = i; bey = j; }
            }

        boolean[][][][][][] visited = new boolean[R][C][R][C][2][2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{rx, ry, bx, by, 0, 0, 0}); // rx,ry,bx,by, rDone, bDone, turn
        visited[rx][ry][bx][by][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r1 = cur[0], c1 = cur[1], r2 = cur[2], c2 = cur[3];
            boolean redDone = cur[4] == 1, blueDone = cur[5] == 1;
            int turn = cur[6];

            if (redDone && blueDone) return turn;

            for (int d1 = 0; d1 < 4; d1++) {
                int nr1 = r1, nc1 = c1;
                if (!redDone) {
                    nr1 = r1 + dx[d1];
                    nc1 = c1 + dy[d1];
                    if (!isInBound(nr1, nc1, R, C) || maze[nr1][nc1] == 5) {
                        nr1 = r1; nc1 = c1; // stay
                    }
                }

                for (int d2 = 0; d2 < 4; d2++) {
                    int nr2 = r2, nc2 = c2;
                    if (!blueDone) {
                        nr2 = r2 + dx[d2];
                        nc2 = c2 + dy[d2];
                        if (!isInBound(nr2, nc2, R, C) || maze[nr2][nc2] == 5) {
                            nr2 = r2; nc2 = c2; // stay
                        }
                    }

                    // 두 수레가 같은 칸 이동 불가
                    if (nr1 == nr2 && nc1 == nc2) continue;

                    // 수레끼리 자리 바꾸기 금지
                    if (nr1 == r2 && nc1 == c2 && nr2 == r1 && nc2 == c1) continue;

                    boolean nRedDone = redDone || (maze[nr1][nc1] == 3);
                    boolean nBlueDone = blueDone || (maze[nr2][nc2] == 4);

                    if (visited[nr1][nc1][nr2][nc2][nRedDone ? 1 : 0][nBlueDone ? 1 : 0]) continue;

                    visited[nr1][nc1][nr2][nc2][nRedDone ? 1 : 0][nBlueDone ? 1 : 0] = true;
                    q.add(new int[]{nr1, nc1, nr2, nc2, nRedDone ? 1 : 0, nBlueDone ? 1 : 0, turn + 1});
                }
            }
        }

        return 0;
    }

    private boolean isInBound(int x, int y, int R, int C) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    public static void main(String[] args) {
        P250134 solution = new P250134();

//        int[][] input = {{1, 4}, {0, 0}, {2, 3}};
//        int result = 3;
        int[][] input = {{1, 0, 2}, {0, 0, 0}, {5, 0, 5}, {4, 0, 3}};
        int result = 7;

        int s = solution.solution(input);

        System.out.println(s + " " +  result);

    }
}
