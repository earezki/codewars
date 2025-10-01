package com.earezki.intersection;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionTest {

    @Test
    void intersect_of_sorted() {
        int[] arr1 = {1, 2, 5, 8};
        int[] arr2 = {2, 8, 9, 10};
        List<Integer> expected = List.of(2, 8);
        Intersection sut = new Intersection();

        assertEquals(expected, sut.intersect_of_sorted(arr1, arr2));
    }

    @Test
    void intersect_of_non_sorted() {
        int[] arr1 = {1, 10, 11 ,2, 5, 8};
        int[] arr2 = {2, 8, 14, 19, 9};
        List<Integer> expected = List.of(2, 8);
        Intersection sut = new Intersection();

        assertEquals(expected, sut.intersect_of_non_sorted(arr1, arr2));
    }
}