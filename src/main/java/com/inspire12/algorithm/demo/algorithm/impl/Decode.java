package com.inspire12.algorithm.demo.algorithm.impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Decode {
    public static void main(String[] args) {
        String s = "2[ac10[xyz]a]";
        String result = "acxyzxyzxyzaacxyzxyzxyza";
//        String result = "acxyzxyzxyzaacxyzxyzxyza";
//        String result = "acxyzxyzxyzxyzaacxyzxyzxyzxyza";
        System.out.println(solution(s));
    }

    private static String solution(String s) {

        Stack<String> spec = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c.toString().equals("]")) {
                String value = spec.pop();
                StringBuilder builder = new StringBuilder();
                while (!value.equals("[")) {
                    builder.insert(0, value);
                    value = spec.pop();
                }
                int complex = 0;
                while(!spec.isEmpty() && Character.isDigit(spec.peek().charAt(0))) {
                    complex += Integer.parseInt(spec.pop()) * 10;
                }
                StringBuilder resultBuilder = new StringBuilder();
                while (complex -- > 0) {
                    resultBuilder.append(builder);
                }
                spec.add(resultBuilder.toString());
            } else {
                spec.add(c.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        for (String a : spec) {
            result.append(a);
        }
        return result.toString();
    }
}
