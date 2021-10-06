package com.inspire12.algorithm.demo.beakjoon.p2667;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static char[][] danji = new char[27][27];

    public static class Pair {
        Integer x;
        Integer y;

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }

        public Integer getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int k = 0; k < line.length(); k++) {
                danji[i][k] = line.charAt(k);
            }
        }
        List<Integer> countList = new ArrayList<>();
        int count = 0;
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (danji[i][k] == '0') {
                    continue;
                }
                stack.push(new Pair(i, k));
                danji[i][k] = '0';
                while (!stack.isEmpty()) {
                    Pair dot = stack.peek();
                    stack.pop();
                    count++;
                    for (int diff = 0; diff < 4; diff++) {
                        int dix = dot.getX() + dx[diff];
                        int diy = dot.getY() + dy[diff];
                        if ((dix >= 0 && dix < N) && (diy >= 0 && diy < N)) {
                            if (danji[dix][diy] == '1') {
                                stack.push(new Pair(dix, diy));
                                danji[dix][diy] = '0';
                            }
                        }
                    }
                }
                countList.add(count);
                count = 0;
            }
        }
        countList.sort((o1, o2) -> o1 - o2);
        System.out.println(countList.size());
        countList.forEach(System.out::println);
    }
}
