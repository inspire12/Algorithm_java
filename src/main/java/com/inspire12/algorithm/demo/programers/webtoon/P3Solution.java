package com.inspire12.algorithm.demo.programers.webtoon;

import java.util.ArrayList;
import java.util.List;

public class P3Solution {
    public int solution(String s, String t) {
        int result = 0;

        for (int sIndex = 0; sIndex < s.length(); sIndex++) {
            if (s.charAt(sIndex) == t.charAt(0)) {
                int m = isMatch(sIndex, s, t);
                if (m > 0) {
                    result += m;
                    sIndex += t.length() * m;
                }
            }
        }
        return result;
    }

    public int isMatch(int sIndex, String s, String t) {
        int match = 0;
        int bound = 0;
        for (int index = 0; index < t.length(); index++) {
            int tIndex = index + sIndex + bound;
            if (s.charAt(tIndex) != t.charAt(index)) {
                if (s.charAt(tIndex) == t.charAt(0)) {
                    int result = isMatch(tIndex, s ,t);
                    if (result > 0) {
                        match += result;
                        bound = t.length() * match;
                        index -= 1;
                        continue;
                    }
                }
                return match;
            }
        }
        return match + 1;
    }
}
