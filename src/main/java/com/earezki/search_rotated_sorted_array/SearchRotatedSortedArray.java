package com.earezki.search_rotated_sorted_array;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (right - left) / 2;

        while (left <= right) {
            if ( nums[mid] == target ) {
                return mid;
            }

            // left side already-sorted
            if (nums[left] < nums[mid] && target < nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }

            // right side already-sorted
            if (nums[right] > nums[mid] && target > nums[mid]) {
            }


            mid = (right - left) / 2;
        }

        return -1;
    }
}
