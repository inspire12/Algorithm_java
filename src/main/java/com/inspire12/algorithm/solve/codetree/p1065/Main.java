package com.inspire12.algorithm.solve.codetree.p1065;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 한수(Hansu) 문제 해결 클래스
 * 
 * 문제: 어떤 양의 정수 X의 각 자리 수가 등차수열을 이룬다면, 그 수를 한수라고 함
 * 예: 123 -> 각 자리 수 차이가 1로 일정 (등차수열)
 *     135 -> 각 자리 수 차이가 2로 일정 (등차수열)
 *     111 -> 각 자리 수 차이가 0으로 일정 (등차수열)
 * 
 * 목표: 1부터 N까지의 수 중에서 한수의 개수를 구하기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성 (키보드 입력을 효율적으로 처리하는 도구)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 사용자로부터 숫자 하나를 입력받음
        String in = br.readLine();
        
        // 문자열을 정수로 변환 (String → int)
        int k = Integer.parseInt(in);
        
        // 계산 결과 출력
        System.out.println(cal(k));
    }

    /**
     * 1부터 k까지의 수 중에서 한수의 개수를 계산하는 메서드
     * 
     * @param k 범위의 끝 숫자
     * @return 한수의 개수
     */
    public static int cal(int k) {
        // 100보다 작은 수들은 모두 한수임 (1자리, 2자리 수는 항상 등차수열)
        // 예: 1, 23, 99 등은 모두 한수
        if (k < 100) {
            return k;
        }
        
        // 1000은 특별 케이스로 처리 (미리 계산된 값)
        if (k == 1000) {
            return 144;
        }
        
        // 99개: 1부터 99까지는 모두 한수
        int c = 99;

        // k를 100으로 나눈 몫 (백의 자리 수)
        // 예: k=543이면 a=5
        int a = k / 100;
        
        // 기본 한수 개수 계산
        // 99개 (1~99) + (a-1) * 5개 (각 백의 자리마다 5개의 한수가 있음)
        // 왜 5개? 100~199에서 한수: 111, 123, 135, 147, 159
        int ans = c + (a - 1) * 5;
        
        // a*100부터 k까지 각 수를 검사해서 한수인지 확인
        // 예: a=5, k=543이면 500~543까지 검사
        for (int i = a * 100; i <= k; i++) {
            if (check(i)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 주어진 수가 한수인지 판단하는 메서드
     * 한수: 각 자리 수가 등차수열을 이루는 수
     * 
     * @param b 검사할 3자리 수
     * @return 한수이면 true, 아니면 false
     */
    public static boolean check(int b) {
        // 각 자리 수를 분리하는 과정 (숫자를 포장지에서 꺼내는 것과 같음)
        int b100 = b / 100;        // 백의 자리: 123 → 1
        int b10 = (b / 10) % 10;   // 십의 자리: 123 → 2
        int b1 = b % 10;           // 일의 자리: 123 → 3
        
        // 등차수열 조건 확인
        // 백의자리 - 십의자리 == 십의자리 - 일의자리
        // 예: 123에서 1-2 == 2-3 → -1 == -1 (참)
        // 예: 135에서 1-3 == 3-5 → -2 == -2 (참)
        return b100 - b10 == b10 - b1;
    }
}

/*
 * 실습 예제들:
 * 1. check(111) 실행해보기 → true (1-1 == 1-1)
 * 2. check(123) 실행해보기 → true (1-2 == 2-3)
 * 3. check(124) 실행해보기 → false (1-2 != 2-4)
 * 4. cal(110) 실행해보기 → 99 + 1 = 100개
 * 
 * 확장 지식:
 * - 등차수열: 연속된 항의 차이가 일정한 수열
 * - 모듈러 연산(%): 나머지를 구하는 연산
 * - 정수 나눗셈(/): 소수점 이하 버림
 * - 알고리즘 최적화: 규칙성을 찾아 반복 계산 줄이기
 */