package com.inspire12.algorithm.demo.leetcode.medium792;

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int output = 0;

        for (int gi =0; gi< words.length; gi++){
            String word = words[gi];
            int SIter = 0;
            if (word.length() < S.length()) {

            } else {

            }
            for (int wordIter = 0 ; wordIter< word.length(); wordIter++) {
                if (word.charAt(wordIter) == S.charAt(SIter)) {

                    wordIter++;
                }
                SIter++;
            }

        }

        return output;
    }
}
