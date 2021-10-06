package com.inspire12.algorithm.demo.beakjoon;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String a = s.solution("rd?e?wg??");
        System.out.println(a);
//        System.out.println(s.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }

    static class Solution {
        // char a ~ z : 97 ~ 122
        public String solution(String riddle) {
            // write your code in Java SE 8
            StringBuilder s = new StringBuilder();

            if (riddle.charAt(0) == '?') {
                if (riddle.length() > 1) {
                    s.append(convertIfRiddleCharacter(riddle.charAt(0), riddle.charAt(1)));
                } else {
                    s.append('a');
                }
            } else {
                s.append(riddle.charAt(0));
            }
            for (int i = 1; i < riddle.length() - 1; i++) {
                s.append(convertIfRiddleCharacter(s.charAt(i-1), riddle.charAt(i), riddle.charAt(i + 1)));
            }
            s.append(convertIfRiddleCharacter(riddle.charAt(s.length() - 2), riddle.charAt(riddle.length() - 1)));
            return s.toString();
        }

        public char convertIfRiddleCharacter(char beforeCharacter, char character, char afterCharacter) {

            if (character == '?') {
                for (int replaceCharacter = 97; replaceCharacter <= 122; replaceCharacter++) {
                    if (beforeCharacter != replaceCharacter && afterCharacter != replaceCharacter){
                        return (char) replaceCharacter;
                    }
                }
            }
            return character;
        }

        public char convertIfRiddleCharacter(char beforeCharacter, char character) {
            if (character == '?') {
                for (int replaceCharacter = 97; replaceCharacter <= 122; replaceCharacter++) {
                    if (beforeCharacter != replaceCharacter){
                        return (char) replaceCharacter;
                    }
                }
            }
            return character;
        }
    }
}

