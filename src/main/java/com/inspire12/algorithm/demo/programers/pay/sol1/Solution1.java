package com.inspire12.algorithm.demo.programers.pay.sol1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution1 {
    public static void main(String[] args) {
        int a = solution(new String[]{"A B C D", "A D", "A B D", "B D"}, 2);
        System.out.println(a);
    }

    public static int solution(String[] id_list, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String ids : id_list) {
            String[] todayIds = ids.split(" ");
            Set<String> todayIdSet = Arrays.stream(todayIds).collect(Collectors.toSet());
            for (String id: todayIdSet) {
                int count = map.getOrDefault(id, 0);
                if (count < k) {
                    map.put(id, map.getOrDefault(id, 0) + 1);
                }
            }
        }
        return map.values().stream().reduce(Integer::sum).orElse(0);
    }
}
