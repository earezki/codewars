package com.earezki.intersection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Intersection {

    public List<Integer> intersect_of_sorted(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];

            int idx = Arrays.binarySearch(nums2, n);
            if (idx >= 0) {
                result.add(n);
            }
        }

        return result;
    }

    public List<Integer> intersect_of_non_sorted(int[] nums1, int[] nums2) {
        Set<Integer> set = IntStream.of(nums2).boxed().collect(Collectors.toSet());

        return IntStream.of(nums1)
                .filter(set::contains)
                .boxed()
                .toList();
    }

}
