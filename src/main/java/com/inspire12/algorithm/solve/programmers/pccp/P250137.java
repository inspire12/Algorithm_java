package com.inspire12.algorithm.solve.programmers.pccp;


import java.util.HashMap;
import java.util.Map;

// 붕대 감기
public class P250137 {

    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        // 1~t -> x * t 회복, t<=50
        // 최대 체력, 0 이하 죽음
        int castingTime = bandage[0];
        int healPerSecond = bandage[1];
        int bonusHeal = bandage[2];
        // 투 포인터 형태로 접근
        int lastTime = attacks[attacks.length - 1][0];
        int[] curHealth = new int[lastTime + 2];
        curHealth[0] = health;
        Map<Integer, Integer> attackTimeToDamageMap = new HashMap<>();
        for (int[] attack : attacks) {
            int time = attack[0];
            int damage = attack[1];
            attackTimeToDamageMap.put(time, damage);
        }
        int countSuceeded = 0;
        for (int t = 0; t < lastTime + 1; t++) {
            if (attackTimeToDamageMap.containsKey(t)) {
                curHealth[t] -= attackTimeToDamageMap.get(t);
                countSuceeded = 0;
                if (curHealth[t] <= 0) {
                    return -1;
                }
            } else {
                curHealth[t] += healPerSecond;
                countSuceeded++;
                if (countSuceeded == castingTime) {
                    curHealth[t] += bonusHeal;
                    countSuceeded = 0;
                }
                curHealth[t] = Math.min(curHealth[t], health);
            }
            curHealth[t + 1] = curHealth[t];
        }
        return curHealth[lastTime]; // 남은 체력, 죽으면 -1
    }

    public static void main(String[] args) {

        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        int result = 5;

        P250137 p = new P250137();
        int solution = p.solution(bandage, health, attacks);
        System.out.println(solution);
        assert result == solution;
    }
}
