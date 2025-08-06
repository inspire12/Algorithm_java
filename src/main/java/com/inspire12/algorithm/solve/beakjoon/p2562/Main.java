package com.inspire12.algorithm.solve.beakjoon.p2562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        SortedMap<Integer, Integer> a = new TreeMap<>(Comparator.comparingInt(o -> o));
        for (int i = 1; i < 10; i++ ) {
            a.put(Integer.parseInt(br.readLine()), i);
        }
        System.out.println(a.lastKey());
        System.out.println(a.get(a.lastKey()));
    }
}
