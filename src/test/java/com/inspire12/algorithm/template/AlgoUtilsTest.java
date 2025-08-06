package com.inspire12.algorithm.template;

import org.junit.jupiter.api.Test;

class AlgoUtilsTest {

    @Test
    void padStart() {
        String e = AlgoUtils.padStart(10, 3, '0');
        System.out.println(e);
    }
}