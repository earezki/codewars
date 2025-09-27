package com.earezki.twoSum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void twoSum() {
        var sut = new TwoSum();

        assertTrue(
                Arrays.compare(
                        new int[] {0,1},
                        sut.twoSum(new int[] {2,7,11,15}, 9)
                ) == 0
        );

        assertTrue(
                Arrays.compare(
                        new int[] {1,2},
                        sut.twoSum(new int[] {3,2,4}, 6)
                ) == 0
        );

        assertTrue(
                Arrays.compare(
                        new int[] {0,1},
                        sut.twoSum(new int[] {3,3}, 6)
                ) == 0
        );
    }
}