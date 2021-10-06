package com.inspire12.algorithm.demo.programers.coupang;

import java.util.ArrayList;
import java.util.List;

public class P2 {
    public long[] solution(long n) {
        long[] answer = {};
        List<Long> factorization = new ArrayList<>();
        for (long i = 2; i <= n; i++) {
            if( n% i == 0) {
                if (factorization.size() > 1 || factorization.contains(i)) {
                    return new long[]{ -1, -1 };
                }
                factorization.add(i);
                n /= i;
                i--;
            }
        }
        return new long[]{-1, -1};
    }
}
