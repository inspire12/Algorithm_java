package com.inspire12.algorithm.demo.algorithm.search.pattern;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSearch {

    public static void main(String[] args) {
        String want = "asdf";
        String all = "asdasdasdfdasdfads";
        List<Integer> index = searchKmp(want, all);

        System.out.println(index);

    }

    // Brute force
    public static int search(String want, String all) {
        for (int index = 0; index < all.length() - want.length(); index++) {
            int tmpIndex = index;
            for (char w : want.toCharArray()) {
                if (w == all.charAt(tmpIndex)) {
                    tmpIndex++;
                } else {
                    break;
                }
            }
            if (tmpIndex - index == want.length()) {
                return index;
            }
        }
        return -1;
    }

    // Kmp
    // 접두사, 접미사 index 리스트 생성: pi
    // 검색하다가 같은 갯수면 pi 값에 확인하고 다음 index에서 가져감
    public static List<Integer> searchKmp(String word, String sentence) {
        final List<Integer> matchedIndices = new ArrayList<>();

        final int sentenceLength = sentence.length();
        final int wordLength = word.length();
        int beginMatch = 0; // the starting position in sentence from which the match started
        int idxWord = 0; // the index of the character of the word that is being compared to a character in string
        final List<Integer> partialTable = createPartialMatchTable(word);
        while (beginMatch + idxWord < sentenceLength)
            if (word.charAt(idxWord) == sentence.charAt(beginMatch + idxWord)) {
                // the characters have matched
                if (idxWord == wordLength - 1) {
                    // the word is complete. we have a match.
                    matchedIndices.add(beginMatch);
                    // restart the search
                    beginMatch = beginMatch + idxWord - partialTable.get(idxWord);
                    if (partialTable.get(idxWord) > -1) idxWord = partialTable.get(idxWord);
                    else idxWord = 0;
                } else idxWord++;
            } else {
                // mismatch. restart the search.
                beginMatch = beginMatch + idxWord - partialTable.get(idxWord);
                if (partialTable.get(idxWord) > -1) idxWord = partialTable.get(idxWord);
                else idxWord = 0;
            }

        return Collections.unmodifiableList(matchedIndices);

    }


    public static List<Integer> createPartialMatchTable(final String word) {
        if (StringUtils.isEmpty(word)) return Collections.EMPTY_LIST;

        final int length = word.length();
        final List<Integer> partialTable = new ArrayList<>(length + 1);
        partialTable.add(-1);
        partialTable.add(0);

        final char firstChar = word.charAt(0);
        for (int idx = 1; idx < word.length(); idx++) {
            final int prevVal = partialTable.get(idx);
            if (prevVal == 0) {
                if (word.charAt(idx) == firstChar) partialTable.add(1);
                else partialTable.add(0);
            } else if (word.charAt(idx) == word.charAt(prevVal)) partialTable.add(prevVal + 1);
            else partialTable.add(0);
        }

        return Collections.unmodifiableList(partialTable);
    }
}
