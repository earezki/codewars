package com.earezki.flood_fill;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.deepEquals;
import static java.util.Arrays.deepToString;
import static org.junit.jupiter.api.Assertions.*;

class FloodFillTest {

    @Test
    void test1() {

        var sut = new FloodFill();

        assertTrue(
            deepEquals(
                    new int[][] {
                            {2,2,2},
                            {2,2,0},
                            {2,0,1} },
                    sut.floodFill(
                            new int[][]{{1, 1, 1},
                                    {1, 1, 0},
                                    {1, 0, 1}}, 1, 1, 2)
            )
        );

        assertTrue(
            deepEquals(
                    new int[][] {
                            {0,0,0},
                            {0,0,0}},
                    sut.floodFill(
                            new int[][]{{0,0,0},
                                    {0,0,0}}, 0, 0, 0)
            )
        );

    }

    @Test
    void test_2() {
        var sut = new FloodFill();

        int[][] actual = sut.floodFill(
                new int[][]{
                        {0, 0, 0},
                        {0, 1, 0}}, 1, 0, 2);

        System.out.println(deepToString(actual));
        assertTrue(
            deepEquals(
                    new int[][] {
                            {2,2,2},
                            {2,1,2}},
                    actual
            )
        );
    }


    @Test
    void test_3() {
        var sut = new FloodFill();

        int[][] actual = sut.floodFill(
                new int[][]{
                        {0, 0, 1},
                        {1, 0, 0}}, 1, 0, 2);

        System.out.println(deepToString(actual));
        assertTrue(
            deepEquals(
                    new int[][] {
                            {0,0,1},
                            {2,0,0}},
                    actual
            )
        );
    }

}