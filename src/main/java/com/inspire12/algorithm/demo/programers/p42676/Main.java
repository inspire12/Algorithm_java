package com.inspire12.algorithm.demo.programers.p42676;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] participants = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = new String[] {"josipa", "filipa", "marina", "nikola"};

        Solution s = new Solution();
        s.solution(participants, completion);
    }
    static class Solution {
        // @param participant <= 100000
        // @param completion = participant- 1
        // 동명이인
        public String solution(String[] participant, String[] completion) {
            // sort
            Map<String, Integer> participantMap = new HashMap<>();

            for (String participantMember: participant) {
                participantMap.put(participantMember, participantMap.getOrDefault(participantMember, 0) + 1);
            }
            for (String completionMember: completion) {
                participantMap.put(completionMember,  participantMap.getOrDefault(completionMember, 0) - 1);
            }

            for (String participantMember: participantMap.keySet()) {
                if (participantMap.get(participantMember) > 0) {
                    return participantMember;
                }
            }
            return "";
        }

        public static class Arrays {
            public static void sort(String[] arr) {
                for (int i =0; i< arr.length; i++) {
                    for (int index=i+1; index < arr.length; index++) {
                        if (arr[index - 1].compareTo(arr[index]) < 0) {
                            swap(arr, index - 1, index);
                        }
                    }
                }
            }

            private static void swap(String[] arr, int front, int back) {
                String tmp = arr[front];
                arr[front] = arr[back];
                arr[back] = tmp;
            }
        }
    }
}
