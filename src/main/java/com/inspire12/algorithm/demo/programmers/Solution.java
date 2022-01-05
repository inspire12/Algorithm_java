package com.inspire12.algorithm.demo.programmers;

import java.util.Stack;

public class Solution {

    /**
     * input    10[ab]
     * output   abababababababababab
     * <p>
     * input    a3[b2[c]v]
     * output   abccvbccvbccv
     */
    private static boolean isNumber(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }

    private static boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        try {
            Integer d = Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static boolean isLowerCase(char c) {
        return c - 'a' >= 0 && c - 'a' <= 27;
    }


    private static String getString(String s) {
        StringBuilder continueStrBuilder = new StringBuilder();
        Stack<String> elementStack = new Stack();
        boolean isPrevNumber = false;
        if (isNumber(s.charAt(0))) {
            isPrevNumber = true;
        }
        for (int sIndex = 0; sIndex < s.length(); sIndex++) {
            char c = s.charAt(sIndex);

            if (c == '[') {
                elementStack.push(continueStrBuilder.toString());
                continueStrBuilder = new StringBuilder();
                isPrevNumber = false;
            } else if (c == ']') {
                String lastestElement = elementStack.pop();
                while (!isNumber(lastestElement)) {
                    continueStrBuilder.insert(0, lastestElement);
                    lastestElement = elementStack.pop();
                }

                String substr = continueStrBuilder.toString();
                continueStrBuilder = new StringBuilder();
                int multipleNumber = Integer.parseInt(lastestElement);

                StringBuilder a = new StringBuilder();
                for (int iter = 0; iter < multipleNumber; iter++) {
                    a.append(substr);
                }
                elementStack.add(a.toString());

            } else if (Solution.isNumber(c)) {
                if (isPrevNumber == false && continueStrBuilder.length() > 0) {
                    elementStack.add(continueStrBuilder.toString());
                    continueStrBuilder = new StringBuilder();
                }
                continueStrBuilder.append(c);
                isPrevNumber = true;
            } else if (Solution.isLowerCase(c)) {
                if (isPrevNumber == true && continueStrBuilder.length() > 0) {
                    elementStack.add(continueStrBuilder.toString());
                    continueStrBuilder = new StringBuilder();
                }
                continueStrBuilder.append(c);
                isPrevNumber = false;
            } else {
                // error
            }

            System.out.printf("character %c, continueStr %s, stack str %s \n", c, continueStrBuilder.toString(), elementStack.toString());
        }
        StringBuilder result = new StringBuilder();
        for(String sub : elementStack) {
            result.append(sub);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String a = getString("10[ab]");
        System.out.println(a == "abababababababababab");

        String b = getString("a10[b2[c]v]");
        System.out.println(b.equals("abccvbccvbccvbccvbccvbccvbccvbccvbccvbccv"));
    }
}
