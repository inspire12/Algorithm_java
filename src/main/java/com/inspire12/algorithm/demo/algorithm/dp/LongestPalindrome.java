package com.inspire12.algorithm.demo.algorithm.dp;

public class LongestPalindrome {
    public static void main(String[] args) {
        int c = longestPalindrome("acacaccb");
        System.out.println(c);
    }

    // 문제: 가장 긴 좌우가 같은 문자열
    // idea

    // brute force
    public static int longestPalindrome(String s) {
        int maxLength = 0;
        for (int start=0; start<s.length(); start++) {
            char c = s.charAt(start);
            for (int end=0; end < s.length(); end++) {
                boolean isPalindrome = true;
                for (int check=0; check < (end - start + 1); check++) {
                    if (s.charAt(check + start) != s.charAt(end - check)) {
                        isPalindrome = false;
                    }
                }

                if (isPalindrome && (end - start) > maxLength ) {
                    maxLength = end - start;
                }
            }
        }
        return maxLength;
    }
    // dp
//    public static int longestPalindromeByDp(String s, int start, int end) {
//        int[][] cache = new int[s.length() + 1][s.length() + 1];
//        int maxValue = 0;
//
//
//        while (start > 0 && end < s.length()) {
//
//            start--;
//            end++;
//        }
//
//        if (s.charAt(start -1) == s.charAt(end + 1)) {
//            cache[start - 1][end + 1] = cache[start][end] + 2;
//            maxValue = Math.max(maxValue, cache[start - 1][end + 1]);
//        }
//
//    }
}
