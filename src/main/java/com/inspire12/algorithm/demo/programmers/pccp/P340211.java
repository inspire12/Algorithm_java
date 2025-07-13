package com.inspire12.algorithm.demo.programmers.pccp;

// PCCP 기출 3 번
// https://school.programmers.co.kr/learn/courses/30/lessons/340211

// 문제 분석
// 2차원 좌표, n개 포인트
// 2대 이상 모이면 충돌 가능성 위험 => 총 몇 번의 위험이 발생했는지
// routes 로봇 - 정해진 [운송 경로]가 존재합니다. x 동시 출발, 한칸씩 이동 대각 x, 루트는 하나(겹치면 r좌표를 먼저)
// 시간 단위 비교가 필요
// 브루트 포스 형태

public class P340211 {
    public static void main(String[] args) {
        P340211 p340211 = new P340211();
        int[][] points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}}; // 운송포인트
        int [][] routes = {{4, 2}, {1, 3}, {2, 4}}; // 로봇
        int result = 1;
        int solution = p340211.solution(points, routes);
        System.out.println(solution == result);
    }
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int length = points.length;
        for (int i =0; i < length; i++) {
            new RobotPoint(points[i][0], points[i][1]);
        }

        return answer;
    }

    class RobotPoint {
        private int x;
        private int y;

        public RobotPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}


