package com.inspire12.algorithm.demo.programmers.pccp;

// PCCP 기출 3 번
// https://school.programmers.co.kr/learn/courses/30/lessons/340211

// 문제 분석
// 2차원 좌표, n개 포인트
// 2대 이상 모이면 충돌 가능성 위험 => 총 몇 번의 위험이 발생했는지
// routes 로봇 - 정해진 [운송 경로]가 존재합니다. x 동시 출발, 한칸씩 이동 대각 x, 루트는 하나(겹치면 r좌표를 먼저)
// x가 먼저 이동 -> 우선 목적지까지 x를 다 이동한 후 y를 이동시킨다
// 시간 단위 비교가 필요
// 브루트 포스 형태
import java.util.*;

class P340211 {
    static class Point {
        int r, c;
        Point(int r, int c) { this.r = r; this.c = c;}
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point)o;
            return r==p.r && c==p.c;
        }
        @Override public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    public int solution(int[][] points, int[][] routes) {

        Map<Integer, Point> mp = new HashMap<>();
        for (int i = 0; i < points.length; i++)
            mp.put(i+1, new Point(points[i][0], points[i][1]));

        List<List<Point>> paths = new ArrayList<>();
        int maxTime = 0;

        for (int[] route : routes) {
            List<Point> path = new ArrayList<>();
            Point cur = mp.get(route[0]);
            path.add(cur);

            for (int j = 1; j < route.length; j++) {
                Point tgt = mp.get(route[j]);
                // r 먼저 이동
                while (cur.r != tgt.r) {
                    cur = new Point(cur.r + Integer.signum(tgt.r - cur.r), cur.c);
                    path.add(cur);
                }
                // 그다음 c 이동
                while (cur.c != tgt.c) {
                    cur = new Point(cur.r, cur.c + Integer.signum(tgt.c - cur.c));
                    path.add(cur);
                }
            }
            maxTime = Math.max(maxTime, path.size());
            paths.add(path);
        }

        int answer = 0;
        for (int t = 0; t < maxTime; t++) {
            Map<Point, Integer> cnt = new HashMap<>();
            for (List<Point> path : paths) {
                if (t < path.size()) {
                    Point p = path.get(t);
                    cnt.put(p, cnt.getOrDefault(p, 0) + 1);
                    if (cnt.get(p) == 2) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {

        int[][] points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes = {{4, 2}, {1, 3}, {2, 4}};
        int answer = 1;
        P340211 p = new P340211();
        int solution = p.solution(points, routes);
        System.out.println(solution == 1);
    }
}

