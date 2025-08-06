package com.inspire12.algorithm.solve.programmers.pccp;

import java.util.Arrays;



public class P340212 {
    public static void main(String[] args) {
//        int[] diffs = new int[]{1, 5, 3};
//        int[] times = new int[] {2, 4, 7};
//        int limit = 30;
//        int result = 3;
        int[] diffs = new int[]{1, 4, 4, 2};
        int[] times = new int[] {6, 3, 8, 2};
        int limit = 59;
        int result = 2;

        P340212 p340212 = new P340212();

        int answer = p340212.solution(diffs, times, limit);
        System.out.println(answer == result);
    }

    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int size = diffs.length;

        // 최초(=최소)로 퍼즐을 다 풀 수 있는 숙련도
        // 문제 풀이 아이디어 -> 레벨을 순차적으로 올리면 속도가 안난다
        // 레벨은 순차적, 레벨을 기준으로
        int left = 1, right = Arrays.stream(diffs).max().orElse(1);
        answer = right;

        // 이진 탐색
        while (left <= right) { // 찾으면
            int level =  left + (right - left) / 2; // mid

            if (check(level, diffs, times, limit)) { // 가능하다면 level 을 낮춘다
                answer = level;
                right = level - 1;
            } else { // 불가능하다면 level 을 올린다
                left  = level + 1;
            }
        }
        return answer;
    }

    private boolean check(int level, int[] diffs, int[] times, long limit) {
        //case 1 diff <= level time_cur 만큼 시간 사용 해결
        //case 2 diff > level  diff - level time_cur 만큼 시간 사용 time_prev 만큼 시간을 사용해 이전 퍼즐을 다시 풀고 와야
        //다시 풀때는 틀리지 않는다
        //case 3 diff - level 번 틀린 이후 time_cur 만큼 시간을 사용하여 퍼즐 해결
        // diff= 3, time_cur = 2, time_prev = 4
        // > level = 1  (3-1 = 2)번 틀림 * 틀릴 때 마다  (2+ 4=6)*2 + 2 = 14
        // > level = 2 (3-2 = 1) (2+4) * 1 + 2 = 8

        long total = times[0];
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                total += times[i];
            } else {
                long wrong = diffs[i] - level;
                total += wrong * (times[i - 1] + times[i]) + times[i];
            }
            if (total > limit) return false;
        }
        return total <= limit;
    }
}
