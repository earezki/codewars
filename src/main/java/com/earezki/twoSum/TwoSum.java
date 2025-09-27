package com.earezki.twoSum;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxByNum = IntStream.range(0, nums.length)
                .collect(HashMap::new,
                        (lhs, idx) -> lhs.put(nums[idx], idx),
                        HashMap::putAll);

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int diff = target - n;

            Integer idx = idxByNum.get(diff);
            if (idx != null && idx != i) {
                return new int[]{i, idx};
            }
        }

        return new int[]{};
    }

}
