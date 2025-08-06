package com.inspire12.algorithm.solve.beakjoon.p1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        int n = 1;
        int p = 0;
        while (k >= p) {
            p = n * (n + 1) / 2;
            if (k <= p) {
                p = n * (n - 1) / 2;
                break;
            }
            n++;
        }
        int s = k - p;
        if (n % 2 == 0) {
            System.out.println(String.format("%d/%d", s, n - s + 1));
        } else {
            System.out.println(String.format("%d/%d", n - s + 1, s));
        }
    }
}
