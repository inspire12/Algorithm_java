package com.inspire12.algorithm.solve.programmers.p389481;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution2 {
    private final static int base26 = 26; // base 26

    public String solution(long n, String[] bans) {
        // 1) bans를 길이별로 그룹화해 숫자 리스트로 변환하고 정렬
        Map<Integer, List<Long>> bannedMap = Arrays.stream(bans)
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(this::toNumber, Collectors.toList())
                ));
        bannedMap.values().forEach(Collections::sort);

        // 2) 올바른 길이 L 찾기 (여기서 total에 26^L을 누적 계산)
        long remaining = n;
        int targetLen = 0;
        long total = 1;  // 26^0
        for (int L = 1; L <= 11; L++) {
            total *= 26;  // 이제 total = 26^L
            long bannedCount = bannedMap.getOrDefault(L, Collections.emptyList()).size();
            long validCount  = total - bannedCount;

            if (remaining <= validCount) {
                targetLen = L;
                break;
            }
            remaining -= validCount;
        }
        if (targetLen == 0) {
            throw new IllegalArgumentException("n이 허용 범위를 초과합니다.");
        }

        // 3) 길이 targetLen 구간에서 remaining번째 유효 숫자를 이진탐색
        long kthNum = findKthValidNumber(targetLen, remaining,
                bannedMap.getOrDefault(targetLen, Collections.emptyList()));

        // 4) 숫자를 문자열로 복원
        return toBase26String(kthNum, targetLen);
    }

    // --- helper methods ---------------------------------------------------

    /** 문자열을 base-26 숫자로 변환 (a→0, b→1, …) */
    private long toNumber(String s) {
        long x = 0;
        for (char c : s.toCharArray()) {
            x = x * 26 + (c - 'a');
        }
        return x;
    }

    /** base-26 숫자 x를 길이 L짜리 문자열로 변환 */
    private String toBase26String(long x, int L) {
        char[] buf = new char[L];
        for (int i = L - 1; i >= 0; i--) {
            buf[i] = (char) ('a' + (int) (x % 26));
            x /= 26;
        }
        return new String(buf);
    }

    /**
     * 길이 L에서 k번째(1-based) 유효 숫자를 이진탐색으로 찾음.
     * total = 26^L를 다시 계산하지 않고, high=total-1로 설정해 줍니다.
     */
    private long findKthValidNumber(int L, long k, List<Long> bannedList) {
        long low = 0, high = 1;
        // high = 26^L - 1 을 반복 곱셈으로 구함
        for (int i = 0; i < L; i++) {
            high = high * 26 + 25;  // (26^i - 1)*26 + 25 = 26^(i+1) - 1
        }

        long answer = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long deletedLeq = countLeq(bannedList, mid);
            long validLeq   = (mid + 1) - deletedLeq;

            if (validLeq >= k) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    /** 정렬된 리스트에서 x 이하의 원소 개수 (upper_bound) */
    private long countLeq(List<Long> list, long x) {
        int idx = Collections.binarySearch(list, x);
        return idx >= 0 ? idx + 1 : -idx - 1;
    }



    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String solution = s.solution(30, new String[]{"d", "e", "bb", "aa", "ae"});
        System.out.println(solution);
    }
}