package com.earezki.top_k_frequent;

import java.util.*;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        if (k == 0) return new int[0];

        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count.compute(
                    nums[i],
                    (_, old) -> old == null ? 1 : old + 1
            );
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                Collections.reverseOrder(Comparator.comparingInt(Map.Entry::getValue))
        );

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            maxHeap.offer(entry);
        }

        int[] result = new int[k];
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            result[i] = maxHeap.poll().getKey();
        }

        //PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
        //        Comparator.comparingInt(Map.Entry::getValue)
        //);

        //for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
        //    minHeap.offer(entry);
        //    if (minHeap.size() > k) {
        //        minHeap.poll();
        //    }
        //}

        //int[] result = new int[k];
        //for (int i = k-1; i >= 0 && !minHeap.isEmpty(); i--) {
        //    result[i] = minHeap.poll().getKey();
        //}

        return result;
    }

}
