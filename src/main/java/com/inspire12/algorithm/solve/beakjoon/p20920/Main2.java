package com.inspire12.algorithm.solve.beakjoon.p20920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main2 {
    public static class StringComparator implements Comparator<Content> {
        @Override
        public int compare(Content o1, Content o2) {
            if (o1.count == o2.count) {
                if (o1.value.length() == o2.value.length()) {
                    return o1.value.compareTo(o2.value);
                }
                return o2.value.length() - o1.value.length();
            }
            return o2.count - o1.count;
        }
    }

    public static class Content {
        int count;
        String value;

        public Content(int count, String value) {
            this.count = count;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        List<Integer> a = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int t = a.get(0);
        HashMap<String, Integer> stringSortedMap = new HashMap<>();
        for (int i = 0; i < t; i++) {
            line = br.readLine();
            if (line.length() >= a.get(1)) {
                stringSortedMap.put(line, stringSortedMap.getOrDefault(line, 0) + 1);
            }
        }
        PriorityQueue<Content> contents = new PriorityQueue<>(new StringComparator());
        for (Map.Entry<String, Integer> aa : stringSortedMap.entrySet()) {
            contents.add(new Content(aa.getValue(), aa.getKey()));
        }

        while(!contents.isEmpty()) {
            System.out.println(contents.poll().value);
        }
    }
}
