package com.earezki.top_k_frequent;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentTest {

    @Test
    void topKFrequent() {
        TopKFrequent sut = new TopKFrequent();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] topK = {1, 2};
        assertTrue(
                Arrays.equals(topK, sut.topKFrequent(nums, k))
        );

        nums = new int[]{1};
        k = 1;
        topK = new int[]{1};
        assertTrue(
                Arrays.equals(topK, sut.topKFrequent(nums, k))
        );

        nums = new int[]{1,2,1,2,1,2,3,1,3,2};
        k = 2;
        topK = new int[]{2,1};
        assertTrue(
                Arrays.equals(topK, sut.topKFrequent(nums, k))
        );

        nums = new int[]{4,1,-1,2,-1,2,3};
        k = 2;
        topK = new int[]{-1,2};
        assertTrue(
                Arrays.equals(topK, sut.topKFrequent(nums, k))
        );

    }

}