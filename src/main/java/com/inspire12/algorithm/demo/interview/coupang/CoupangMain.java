package com.inspire12.algorithm.demo.interview.coupang;

public class CoupangMain {
    public static void main(String[] args) {
//        P1 p1 = new P1();

//        int n = 6;
//        int[][] delivery = new int[][] {
//                {1,3,1},
//                {3,5,0},
//                {5,4,0},
//                {2,5,0}
//        };
//        int n = 7;
//        int[][] delivery = new int[][] {
//                {5,6,0},
//                {1,3,1}, {1,5,0}, {7,6,0},{3,7,1},{2,5,0}
//        };
//
//        String result = p1.solution(n, delivery);
//        System.out.println(result);

//        int n = 7919;
//        P2 p2 = new P2();
//        long[] a = p2.solution(n);
//        for (long b : a) {
//            System.out.println(b);
//        }
        P3 p3 = new P3();
//        int[][] board = {{3, 2, 3, 2},
//                {2, 1, 1, 2}, {1, 1, 2, 1}, {4, 1, 1, 1}};
//        int[][] board = {{4,2,3,2}, {2,1,2,4}, {1,2,3,1}, {4,1,4,3}};
//        int[][] board = {{4,4,4,1},{4,1,1,1},{1,1,1,1},{1,1,1,1}};
//        int[][] board = {{4,4,3,2}, {4,1,2,4}, {1,2,3,1}, {4,1,4,3}};
//        int[][] board = {{4,4,3,2}, {4,1,2,4}, {1,2,3,1}, {4,1,4,3}};
        int[][] board = {{3, 2, 3, 2},
                {2, 1, 1, 1}, {1, 1, 2, 1}, {4, 1, 1, 1}};

        int a = p3.solution(board);
        System.out.println(a);
    }
}
