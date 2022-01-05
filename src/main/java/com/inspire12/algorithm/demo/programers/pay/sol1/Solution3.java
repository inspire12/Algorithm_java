package com.inspire12.algorithm.demo.programers.pay.sol1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution3 {
    public static void main(String[] args) {
        String[] logs = new String[] {
                "0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"
        };
        for (String s : solution(logs)) {
            System.out.println(s);
        }
    }

    private static class GradeCard implements Comparable<GradeCard>{

        public int problemNum;
        public int point;

        public GradeCard(String problemNum, String point) {
            this.point = Integer.parseInt(point);
            this.problemNum = Integer.parseInt(problemNum);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GradeCard gradeCard = (GradeCard) o;
            return problemNum == gradeCard.problemNum &&
                    point == gradeCard.point;
        }

        @Override
        public int hashCode() {
            return Objects.hash(problemNum, point);
        }

        @Override
        public int compareTo(GradeCard o) {
            return this.problemNum - o.problemNum;
        }
    }
    public static String[] solution(String[] logs) {

        SortedMap<String, TreeSet<GradeCard>> map = new TreeMap<>();
        for (int i = logs.length - 1; i >=0; i--) {
            String log = logs[i];
            String[] splitLog = log.split(" ");
            String num = splitLog[0];
            String problemNum = splitLog[1];
            String point = splitLog[2];
            TreeSet<GradeCard> grades = map.getOrDefault(num, new TreeSet<>());
            grades.add(new GradeCard(problemNum, point));
            map.put(num, grades);
        }
        Set<String> answers = new HashSet<>();
        List<String> keys = new ArrayList<>(map.keySet());
        List<GradeCard> compare = new ArrayList<>(map.get(keys.get(0)));
        boolean isFirst = true;
        for (int i = 1 ; i < keys.size(); i++) {
            List<GradeCard> cur = new ArrayList<>(map.get(keys.get(i)));
            if (equals(compare, cur)) {
                answers.add(keys.get(i));
                if (isFirst) {
                    answers.add(keys.get(0));
                }
            } else {
                compare = cur;
                isFirst = false;
            }
        }
        if (answers.isEmpty()) {
            return new String[]{"None"};
        }
        return answers.toArray(new String[0]);
    }

    private static boolean equals(List<GradeCard> a, List<GradeCard> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }
}
