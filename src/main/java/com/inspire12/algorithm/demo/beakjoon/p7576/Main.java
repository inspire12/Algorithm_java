package com.inspire12.algorithm.demo.beakjoon.p7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[][] tomatos = new int[1002][1002];
    private static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        tomatos = new int[M + 1][N + 1];
        Queue<Dot> prevRipe = new LinkedList<>();

        for (int y = 0; y < N; y++) {
            String[] line = br.readLine().split(" ");
            for (int x = 0; x < line.length; x++) {
                tomatos[y][x] = Integer.parseInt(line[x]);
                if (tomatos[y][x] == 1) {
                    prevRipe.add(new Dot(x, y));
                }
            }
        }

        while (!prevRipe.isEmpty()) {

        }

    }
}
