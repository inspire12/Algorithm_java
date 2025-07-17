package com.inspire12.algorithm.demo.programmers.pccp;

import java.util.*;

// 풀이
// 덧셈, 뺄셈
// 2~9진법
// 음수가 되거나 서로 모순되는 수식은 주어지지 않습니다.
public class P340210 {

    public static String[] solution(String[] expressions) {
        List<String> restored = new ArrayList<>();

        // 진법 후보: 2 ~ 9 중 모두 true로 초기화
        boolean[] validBases = new boolean[10];
        Arrays.fill(validBases, true);
        validBases[0] = false;
        validBases[1] = false;

        // 결과가 있는 수식으로 진법 후보 좁히기
        int maxDigit = 0;
        for (String expr : expressions) {
            if (!expr.contains("X")) {
                String[] parts = expr.split(" ");
                maxDigit = Math.max(maxDigit, getMaxDigit(parts[0], parts[2], parts[4]));
            } else {
                String[] parts = expr.split(" ");
                maxDigit = Math.max(maxDigit, getMaxDigit(parts[0], parts[2]));
            }
        }
        if (maxDigit >= 10) {
            maxDigit = 9;
        }
        for (String expr : expressions) {
            if (!expr.contains("X")) {
                boolean[] currentValid = getValidBases(expr, maxDigit + 1);
                for (int b = maxDigit; b <= 9; b++) {
                    validBases[b] = validBases[b] && currentValid[b];
                }
            }
        }

        // 각 수식 복원
        for (String expr : expressions) {
            if (expr.contains("X")) {
                restored.add(restoreOne(expr, validBases, maxDigit));
            }
        }

        return restored.toArray(new String[0]);
    }

    private static boolean[] getValidBases(String expr, int baseMin) {
        boolean[] isValid = new boolean[10];
        Arrays.fill(isValid, false);

        String[] parts = expr.split(" ");
        String A = parts[0], op = parts[1], B = parts[2], C = parts[4];

        for (int base = baseMin; base <= 9; base++) {
            try {
                int a = Integer.parseInt(A, base);
                int b = Integer.parseInt(B, base);
                int c = Integer.parseInt(C, base);

                int result = op.equals("+") ? a + b : a - b;
                if (result == c) isValid[base] = true;
            } catch (Exception e) {
                // 이 base에서는 파싱 불가
            }
        }
        return isValid;
    }

    private static String restoreOne(String expr, boolean[] validBases, int maxDigit) {
        String[] parts = expr.split(" ");
        String A = parts[0], op = parts[1], B = parts[2];
        Set<String> candidateResults = new HashSet<>();

        for (int base = maxDigit + 1; base <= 9; base++) {
            if (!validBases[base]) continue;

            try {
                int a = Integer.parseInt(A, base);
                int b = Integer.parseInt(B, base);
                int result = op.equals("+") ? a + b : a - b;

                if (result < 0) continue;

                String resultStr = Integer.toString(result, base).toUpperCase();
                candidateResults.add(resultStr);
            } catch (Exception e) {
                // 파싱 불가 → 무시
            }
        }

        if (candidateResults.size() == 1) {
            String value = candidateResults.iterator().next();
            return A + " " + op + " " + B + " = " + value;
        } else {
            return A + " " + op + " " + B + " = ?";
        }
    }

    private static int getMaxDigit(String... strs) {
        int max = 0;
        for (String s : strs) {
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    max = Math.max(max, getMaxDigit(c - '0'));
                }
            }
        }
        return max;
    }

    public static int getMaxDigit(int num) {  // 가장 큰 숫자(digit) 리턴
        int maxDigit = -1;
        while (num > 0) {
            if (num % 10 > maxDigit)
                maxDigit = num % 10;
            num /= 10;
        }
        return maxDigit;
    }

    public static void main(String[] args) {
        String[] expressions = {"2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "5 - 5 = X"};
        String[] result =  {"2 + 2 = 4", "7 + 4 = ?", "5 - 5 = 0"};

        P340210 p340210 = new P340210();
        String[] solution = p340210.solution(expressions);

        Arrays.stream(solution).forEach(System.out::println);


//        {"1 + 1 = 2", "1 + 3 = 4", "1 + 5 = X", "1 + 2 = X"}	{"1 + 5 = ?", "1 + 2 = 3"}
//        {"10 - 2 = X", "30 + 31 = 101", "3 + 3 = X", "33 + 33 = X"}	{"10 - 2 = 4", "3 + 3 = 10", "33 + 33 = 110"}
//        {"2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "5 - 5 = X"}	{"2 + 2 = 4", "7 + 4 = ?", "5 - 5 = 0"}
//        {"2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "8 + 4 = X"}	{"2 + 2 = 4", "7 + 4 = 12", "8 + 4 = 13"}


    }
}
