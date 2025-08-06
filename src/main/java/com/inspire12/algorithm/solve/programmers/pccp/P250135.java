package com.inspire12.algorithm.solve.programmers.pccp;

public class P250135 {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;
        int count = 0;

        double[] prev = getAngles(h1, m1, s1);
        if (Math.abs(prev[0] - prev[1]) < 1e-6 && Math.abs(prev[1] - prev[2]) < 1e-6) {
            count++; // 시작 시점 겹침
        }

        for (int t = start; t < end; t++) {
            int h = (t / 3600) % 24;
            int m = (t % 3600) / 60;
            int s = t % 60;

            int nextT = t + 1;
            int h2_ = (nextT / 3600) % 24;
            int m2_ = (nextT % 3600) / 60;
            int s2_ = nextT % 60;

            double[] now = getAngles(h, m, s);
            double[] next = getAngles(h2_, m2_, s2_);

            double secondNow = now[2];
            double minuteNow = now[1];
            double hourNow = now[0];

            double secondNext = next[2];
            double minuteNext = next[1];
            double hourNext = next[0];

            // 초침이 분침 또는 시침을 지나쳤는지: 각도 차의 부호가 달라졌는지 확인
            if (crossed(secondNow, secondNext, minuteNow, minuteNext)) {
                System.out.println(h + " " + m + " " + s + " / "
                        + secondNow + " " + minuteNow + " " + secondNext + " " + minuteNext);
                count++;
            }
            else if (crossed(secondNow, secondNext, hourNow, hourNext)) {
                System.out.println(h + " " + m + " " + s + " / "
                        + secondNow + " " + hourNow + " " + secondNext + " " + hourNext);
                count++;
            }


            prev = next;
        }

        return count;
    }

    private static boolean crossed(double s1, double s2, double t1, double t2) {
        if (s1 > 300 && s2 < 60) {
            return false;
        }
        return (s1 - t1) * (s2 - t2) < 0;
    }

    private static double[] getAngles(int h, int m, int s) {
        double hour = (h % 12) * 30 + m * 0.5 + s / 120.0;
        double minute = m * 6 + s * 0.1;
        double second = s * 6;
        return new double[] { hour, minute, second };
    }

    public static void main(String[] args) {

        P250135 solution = new P250135();
        int answer = solution.solution(0, 5, 30, 0, 7, 0);
        int result = 2;
//        int answer = solution.solution(	12, 0, 0, 12, 0, 30);
//        int result = 1;
        System.out.println(result + " " + answer);
        assert answer == result;
    }
}
