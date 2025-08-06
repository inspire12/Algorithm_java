package com.inspire12.algorithm.solve.beakjoon.p2884;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int hour = Integer.parseInt(input[0]);
        int minute = Integer.parseInt(input[1]);

        LocalTime time = LocalTime.of(hour, minute);
        time = time.minusMinutes(45);

        System.out.println(time.getHour() + " " + time.getMinute());
    }
}
