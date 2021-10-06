package com.inspire12.algorithm.demo.beakjoon.p9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(card(n));
        }
    }

    public static int card(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] card = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            card[i] = 0;
        }
        if (n < 3) {
            return n;
        }
        card[1] = 1;
        card[2] = 2;
        card[3] = 4;
        for (int i = 4; i < n + 1; i++) {
            card[i] = card[i - 1] + card[i - 2] + card[i - 3];
        }
        return card[n];
    }
}
