package com.inspire12.algorithm.solve.beakjoon.p20920;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o2.length() - o1.length();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        String[] a = line.split(" ");
        int t = Integer.parseInt(a[0]);
        LinkedHashMap<String, Integer> stringSortedMap = new LinkedHashMap<>();
        for (int i = 0; i < t; i++) {
            line = br.readLine();
            if (line.length() >= Integer.parseInt(a[1])) {
                stringSortedMap.put(line, stringSortedMap.getOrDefault(line, 0) + 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> entries = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        entries.addAll(stringSortedMap.entrySet());

        PriorityQueue<String> pq = new PriorityQueue<>(new StringComparator());
        int preCount = 0;
        while(!entries.isEmpty()) {
            Map.Entry<String, Integer> entry = entries.poll();
            if (preCount != entry.getValue() && preCount != 0) {
                while (!pq.isEmpty()){
                    System.out.println(pq.poll());
                }
            }
            pq.offer(entry.getKey());
            preCount = entry.getValue();
        }
        StringBuilder print = new StringBuilder();
        while (!pq.isEmpty()){
            print.append(pq.poll()).append("\n");
        }
        bw.write(print.toString());
        bw.flush();
    }
}
