package com.inspire12.algorithm.solve.leetcode;

import org.springframework.stereotype.Service;

@Service
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        int[][] cache = new int[s.length()][s.length()];
        int start = 0;
        int end = 0;
        int maxLength = 1;
        for (int i=0; i< s.length(); i++) {
            for (int j=i; j<s.length(); j++) {
                cache[i][j] = 0;
                if (i == j) {
                    cache[i][j] = 1;
                } else if (j == i +1 && s.charAt(i) == s.charAt(j)){
                    cache[i][j] = 2;
                    start = i;
                    end = j;
                }
            }
        }

        for (int k = 1; k< s.length(); k++ ){
            for (int i =0; i + k < s.length(); i++) {
                if(s.charAt(i) == s.charAt(i + k) && i+1 <= i+k-1 ) {
                    if (cache[i+1][i+k-1] == 0) {
                        continue;
                    }
                    cache[i][i +k] = cache[i+1][i+k-1] + 2;
                    if (cache[i][i+k] > maxLength) {
                        maxLength = cache[i][i +k];
                        start = i;
                        end = i+k;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
