package com.inspire12.algorithm.demo.programers.webtoon;

import java.util.Arrays;
import java.util.Collections;

public class P1Solution {
    public int solution(int[] prices, int[] discounts) {
        int answer = 0;
        int[] sortedPrices = Arrays.stream(prices)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int[] sortedDiscount = Arrays.stream(discounts)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        if (sortedPrices.length <= sortedDiscount.length) {
            for (int i = 0; i < sortedPrices.length; i++) {
                answer += sortedPrices[i] * (100 - sortedDiscount[i]);
            }
            answer *= 0.01;
        } else {
            for (int i = 0; i < sortedDiscount.length; i++) {
                answer += sortedPrices[i] * (100 - sortedDiscount[i]);
            }
            answer *= 0.01;
            for (int i = sortedDiscount.length; i< sortedPrices.length; i++) {
                answer += sortedPrices[i];
            }
        }

        return answer;
    }
}
