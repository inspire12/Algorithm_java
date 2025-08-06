package com.inspire12.algorithm.solve.beakjoon;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BolierBeakjoon {
    public static void main(String[] args) throws IOException {
        solve();
    }
    public static void solve() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        while (!StringUtils.isEmpty(input = bufferedReader.readLine())) {

            int tmp = Integer.parseInt(input);

            list.add(tmp);
            sum += tmp;
        }
        list.sort(Comparator.comparingInt(o -> o));
        int check = sum - 100;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (check == list.get(i) + list.get(j)) {
                    List<Integer> a = Arrays.asList(list.get(i), list.get(j));
                    list.stream().filter(value -> !a.contains(value))
                            .forEach(System.out::println);
                    return ;
                }
            }
        }
    }

}
