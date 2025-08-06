package com.inspire12.algorithm.solve.beakjoon.p1065;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int k = Integer.parseInt(in);
        System.out.println(cal(k));
    }

    public static int cal(int k) {
        if (k < 100) {
            return k;
        }
        if (k == 1000) {
            return 144;
        }
        int c = 99;

        int a = k / 100;
        int ans = c + (a - 1) * 5;
        for (int i = a * 100; i <= k; i++) {
            if (check(i)) {
                ans++;
            }
        }
        return ans;
    }

    public static boolean check(int b) {
        int b100 = b / 100;
        int b10 = (b / 10) % 10;
        int b1 = b % 10;
        return b100 - b10 == b10 - b1;
    }
}