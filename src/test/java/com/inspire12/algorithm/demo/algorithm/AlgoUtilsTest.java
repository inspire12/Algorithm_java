package com.inspire12.algorithm.demo.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgoUtilsTest {

    @Test
    void padStart() {
        String e = AlgoUtils.padStart(10, 3, '0');
        System.out.println(e);
    }
}