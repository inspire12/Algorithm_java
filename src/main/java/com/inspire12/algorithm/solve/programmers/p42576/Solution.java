package com.inspire12.algorithm.solve.programmers.p42576;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Solution {
    public static void main(String[] args) {
        int[] a = solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[] {500, 600, 150, 800, 2500});

        System.out.println(a);
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();

        Map<String, List<A>> map2 = new HashMap<>();
        List<A> genreObject = new ArrayList<>();
        List<Integer> returns = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            A a = new A(genres[i], i, plays[i]);
            genreObject.add(a);
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            List<A> tmp = map2.getOrDefault(genres[i], new ArrayList<>());
            tmp.add(a);
            map2.put(genres[i], tmp);
        }

        for (Map.Entry<String, Integer> m :
                map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).collect(Collectors.toList())) {
            map2.get(m.getKey()).sort((o1, o2) -> o2.play - o1.play);
            int index = 0;
            for (A a : map2.get(m.getKey())){
                returns.add(a.index);
                index++;
                if (index >= 2) {
                    break;
                }
            }
        }

        int[] answer = new int[returns.size()];
        int size = 0;
        for(int i : returns) {
            answer[size++] = i;
        }
        return answer;
    }
    public static class A {
        String genre;
        Integer index;
        Integer play;
        public A (String genre, Integer index, Integer play) {
            this.genre = genre;
            this.index = index;
            this.play = play;
        }
    }
}

