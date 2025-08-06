package com.inspire12.algorithm.template.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberUtils {
    public static boolean isPrime(int number) {
        if (number <= 2) return false;


        for (int i = 3; i < Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static List<String> findPermutation(List<String> numbers) {
        return new Permutation(numbers).run().getResults();
    }

    private static class Permutation {
        private List<String> numbers;
        private List<Boolean> visits;
        private List<String> results;

        public Permutation(List<String> numbers) {
            this.numbers = numbers;
            this.visits = new ArrayList<>(Collections.nCopies(numbers.size(), false));
            this.results = new ArrayList<>();
        }

        public Permutation run() {
            dfs("",0);
            return this;
        }

        public void dfs(String part, int depth) {
            if (depth > numbers.size()) return;
            for (int i = 0; i < numbers.size(); i++) {
                if (visits.get(i)) continue;
                visits.set(i, true);
                dfs(part + this.numbers.get(i),depth + 1);
                visits.set(i, false);
                this.results.add(part + this.numbers.get(i));
            }
        }

        public List<String> getResults() {
            return this.results;
        }
    }
}