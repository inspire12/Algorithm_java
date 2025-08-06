package com.inspire12.algorithm.solve.beakjoon.p14681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer a = Integer.parseInt(br.readLine());
        Integer b = Integer.parseInt(br.readLine());
        if (a > 0 && b > 0) {
            System.out.println(1);
        } else if(a > 0 && b < 0) {
            System.out.println(4);
        } else if(a < 0 && b < 0) {
            System.out.println(3);
        } else {
            System.out.println(2);
        }
    }
}
