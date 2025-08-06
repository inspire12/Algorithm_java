package com.inspire12.algorithm.solve.codetree.hashmap;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int n = Integer.parseInt(in);

        Map<Integer, Integer> map = new HashMap<>();
        int y = 0;
        while (n-- > 0) {
            in = br.readLine();
            String[] ins = in.split(" ");
            int x = Integer.parseInt(ins[0]);
            y = Integer.parseInt(ins[1]);

            if (map.containsKey(x)) {
                if (map.get(x) > y) {
                    map.put(x, y);
                }
            } else {
                map.put(x, y);
            }

        }
        long sum = 0;
        for (Map.Entry<Integer, Integer> yy : map.entrySet()) {
            sum +=yy.getValue();
        }
        System.out.println(sum);

    }

    static class Graph {
        int s;
        int t;

    }
}