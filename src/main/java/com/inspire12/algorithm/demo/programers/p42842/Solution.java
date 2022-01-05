package com.inspire12.algorithm.demo.programers.p42842;

public class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sumXY = (brown/2) + 2;
        int subXY = (int) Math.sqrt(Math.pow(2 - brown/2.0, 2) - (4*yellow));
        int X = (sumXY + subXY) / 2;
        int Y = sumXY - X;

        answer = new int[]{X, Y};

        return answer;
    }
}
