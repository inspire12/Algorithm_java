package com.inspire12.algorithm.solve.beakjoon.thinking_contest.a;

import java.util.Scanner;

public class SolutionA {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String start = "고무오리 디버깅 시작";
        final String problem = "문제";
        final String rubberDuck = "고무오리";
        final String end = "고무오리 디버깅 끝";
        final String ment = "고무오리야 사랑해";
        final String mentFail = "힝구";
        int problemCount = 0;
        String input = scanner.nextLine();
        while (!end.equals(input)) {
            input = scanner.nextLine();
            if(problem.equals(input)) {
                problemCount ++;
            } else if (rubberDuck.equals(input)) {
                if (problemCount > 0) {
                    problemCount--;
                } else {
                    problemCount += 2;
                }
            }
        }

        System.out.println(problemCount == 0 ? ment: mentFail);
    }
}
