package com.inspire12.algorithm.demo.beakjoon.p1330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String a[] = line.split(" ");
        if (Integer.parseInt(a[0]) < Integer.parseInt(a[1])) {
            System.out.println("<");
        } else if (Integer.parseInt(a[0]) > Integer.parseInt(a[1])) {
            System.out.println(">");
        } else {
            System.out.println("==");
        }
    }
}
