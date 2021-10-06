package com.inspire12.algorithm.demo.programers.coupang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class P1 {
    public String solution(int n, int[][] delivery) {
        char[] nlist = new char[1002];
        Arrays.sort(delivery, (o1, o2) -> o2[2] - o1[2]);
        for (int[] deliver : delivery) {
            int a = deliver[0];
            int b = deliver[1];
            int c = deliver[2];
            if (c == 1) {
                nlist[a] = 'O';
                nlist[b] = 'O';
            }
            else if (c == 0) {
                if (nlist[a] == 'O') {
                    nlist[b] = 'X';
                }
                if (nlist[b] == 'O') {
                    nlist[a] = 'X';
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i=1; i<=n; i++) {
            if (nlist[i] == 0) {
                builder.append('?');
            } else {
                builder.append(nlist[i]);
            }
        }
        return builder.toString();
    }
}
