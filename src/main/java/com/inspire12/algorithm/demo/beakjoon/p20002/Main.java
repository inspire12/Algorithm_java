package com.inspire12.algorithm.demo.beakjoon.p20002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer st;

        Integer n = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        int[][] dataSet = new int[n][n];

        for (int row = 0; row < n; row++) {
            int data = 0;
            input = br.readLine();
            st = new StringTokenizer(input);
            for (int col = 0; col < n; col++) {
                data += Integer.parseInt(st.nextToken());
                dataSet[row][col] = data;
            }
        }
        print(dataSet);
        int[][] sumOfData = new int[n+1][n+1];
        for (int row = 1; row < n + 1; row++) {
            for (int col = 1; col < n + 1; col++) {
                sumOfData[row][col] = sumOfData[row - 1][col] + dataSet[row-1][col-1];
            }
        }
        print(sumOfData);
        for (int row = 1; row < n + 1; row++) {
            for (int col = 1; col < n + 1; col++) {
                for (int rate = 1; (row - rate >= 0) && (col - rate >= 0); rate++) {
                    int value = sumOfData[row][col] - sumOfData[row - rate][col] - sumOfData[row][col - rate] + sumOfData[row - rate][col - rate];
                    if (value > max) max = value;
                }
            }
        }
        System.out.print(max);
    }
    private static void print(int[][] sum) {
        for (int[] arr : sum) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
