package com.inspire12.algorithm.solve.beakjoon.p2693;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            List<Integer> list = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .sorted((o1, o2) -> o2 - o1)
                    .collect(Collectors.toList());
            System.out.println(list.get(2));
        }
    }
}
