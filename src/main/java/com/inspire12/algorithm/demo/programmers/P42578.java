package com.inspire12.algorithm.demo.programmers;

import java.util.HashMap;
import java.util.Map;

public class P42578 {
    public static void main(String[] args) {
        String[][] a = new String[][]{
                new String[]{"yellow_hat", "headgear"},
                new String[]{"blue_sunglasses", "eyewear"},
                new String[]{"green_turban", "headgear"}};
        solution(a);
    }
    public static int solution(String[][] clothes) {
        int answer = 1;
        int sub = 0;
        Map<String, Integer> clothesCount = groupByType(clothes);
        for (Integer count : clothesCount.values()) {
            answer = answer * (count + 1);
        }

        if (clothesCount.keySet().size() == 1) {
            return clothesCount.keySet().size();
        }
        return answer - 1;
    }

    // 매일 다른 옷 조합
    public static Map<String, Integer> groupByType(String[][] clothes) {
        Map<String, Integer> answer = new HashMap<>();
        for (String[] cloth : clothes) {
            answer.put(cloth[1], answer.getOrDefault(cloth[1], 0) + 1);
        }
        return answer;
    }
}
