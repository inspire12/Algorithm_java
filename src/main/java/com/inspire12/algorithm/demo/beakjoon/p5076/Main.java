package com.inspire12.algorithm.demo.beakjoon.p5076;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (!line.equals("#")) {
            if (isLegalHtmlTag(line)) {
                System.out.println("legal");
            } else {
                System.out.println("illegal");
            }
            line = br.readLine();
        }
    }

    private static boolean isLegalHtmlTag(String line) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char text = line.charAt(i);
            if (text == '<') {
                if (line.charAt(i+1) =='/') {
                    StringBuilder sb = new StringBuilder();
                    sb.append(line.charAt(i));
                    while (line.charAt(i) != '>' && i < line.length()) {
                        i++;
                        sb.append(line.charAt(i));
                    }
                    if (sb.toString().equals("</br>")) {
                        continue;
                    }
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!isMatch(stack.pop(), sb.toString())) {
                        return false;
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(line.charAt(i));
                    while (line.charAt(i) != '>' && i < line.length()) {
                        i++;
                        sb.append(line.charAt(i));
                    }
                    if (sb.toString().equals("<br />")) {
                        continue;
                    }
                    stack.add(sb.toString());
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private static boolean isMatch(String openTag, String closeTag) {

        if (openTag.split(" ").length > 1) {
            openTag = openTag.split(" ")[0] + ">";
        }
        return openTag.length() == closeTag.length() - 1 && openTag.substring(1).equals(closeTag.substring(2));
    }
}
