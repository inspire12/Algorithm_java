package com.inspire12.algorithm.demo.programmers.pccp;

import java.util.*;

public class P250136 {

    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean inBound(int nextPos, int boundLow, int boundHigh) {
        return nextPos >= boundLow && nextPos < boundHigh;
    }

    public int bfsVisit(int[][] land, boolean[][] visit, int[][] group, int startX, int startY, int groupId) {
        visit[startY][startX] = true;
        LinkedList<Point> queue = new LinkedList<>();

        visit[startY][startX] = true;
        group[startY][startX] = groupId;
        int ammount = 1;
        queue.add(new Point(startX, startY));
        // dfs
        while (!queue.isEmpty()) {
            Point pop = queue.pop();
            int x = pop.x;
            int y = pop.y;
            for (int direction = 0; direction < 4; direction++) {
                int nextX = x + dx[direction];
                int nextY = y + dy[direction];
                if (!inBound(nextX, 0, land[0].length) || !inBound(nextY, 0, land.length)) {
                    continue;
                }
                // 방문 기록이 없는 +
                if (land[nextY][nextX] == 1 && !visit[nextY][nextX]) {
                    visit[nextY][nextX] = true;
                    group[nextY][nextX] = groupId;
                    ammount++;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }
        return ammount;
    }

    public int solution(int[][] land) {

        int n = land.length; // 세로
        int m = land[0].length; // 가로

        boolean[][] visit = new boolean[n][m];
        int[][] group = new int[n][m];
        int groupId = 1;
        Map<Integer, Integer> groupToAmmountMap = new HashMap<>();

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (!visit[y][x] && land[y][x] == 1) {
                    int amount = bfsVisit(land, visit, group, x, y, groupId);
                    groupToAmmountMap.put(groupId, amount);
                    groupId++;
                }
            }
        }

        int maxCount = 0;

        for (int x = 0; x < m; x++) {
            int count = 0;
            Set<Integer> s = new HashSet<>();
            for (int y = 0; y < n; y++) {
                if (group[y][x] != 0 && !s.contains(group[y][x])) {
                    count += groupToAmmountMap.getOrDefault(group[y][x], 0);
                }
                s.add(group[y][x]);
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }


    public static void main(String[] args) {
        P250136 p = new P250136();
        // 가로 x < m, 세로 y < n
        // case 1
        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        int result = 9;
        // case 2
//        int[][] land = {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};
//        int result = 16;

        int solution = p.solution(land);

        System.out.println(solution);
        assert solution == result;
    }
}
