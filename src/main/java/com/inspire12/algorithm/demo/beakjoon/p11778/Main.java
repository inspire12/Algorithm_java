package com.inspire12.algorithm.demo.beakjoon.p11778;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> c = Arrays.stream(br.readLine().split(" "))
                .map(a -> Long.parseLong(a))
                .collect(Collectors.toList());
        long n = c.get(0);
        long m = c.get(1);
        System.out.println(solve(gcd(n, m)));
    }

    public static long getPibonacci(long n) {
        int loop = 100;
        long[] number = new long[loop];
        number[0] = 0;
        number[1] = 1;
        long mod = 1_000_000_007;
        for (int i = 0; i <= n - 2; i++) {
            number[(i + 2) % loop] = (number[(i) % loop] + number[(i + 1) % loop]) % mod;
        }
        return number[(int) (n % loop)];
    }

    public static long solve(long m) {
        if (m <= 1) {
            return m;
        }
        long ans[][] = { { 1, 0 }, { 0, 1 } }; // 단위행렬
        long a[][] = { { 1, 1 }, { 1, 0 } };
        while (m > 0) {
            if (m % 2 == 1) {
                ans = productMatrix(ans, a);
            }
            a = productMatrix(a, a);
            m /= 2;
        }
        return ans[0][1];
    }

    public static long[][] productMatrix(long[][] a, long[][] b) {
        long mod = 1_000_000_007;
        long[][] answer = new long[a.length][b.length];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                for (int k = 0; k < answer[0].length; k++) {
                    answer[i][j] += a[i][k] * b[k][j];
                }
                answer[i][j] %= mod;
            }
        }
        return answer;
    }

    public static long gcd(long a, long b) {
        if (a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}
