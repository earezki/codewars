package com.earezki.pagination_helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.function.IntSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaginationHelperTest {

    private PaginationHelper<Character> helper;

    @BeforeEach
    void init() {
        helper = new PaginationHelper<>(List.of('a', 'b', 'c', 'd', 'e', 'f'), 4);
    }

    @Test
    void test_n1() {
        assertEquals(2, helper.pageCount());
        assertEquals(6, helper.itemCount());
        assertEquals(4, helper.pageItemCount(0));
        assertEquals(2, helper.pageItemCount(1));
        assertEquals(-1, helper.pageItemCount(2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,5", "0,2", "-1,20", "-1,-10"})
    void test_n2(String input) {
        IntSupplier expected = () -> Integer.parseInt(input.split(",")[0]);
        IntSupplier argument = () -> Integer.parseInt(input.split(",")[1]);

        assertEquals(expected.getAsInt(), helper.pageIndex(argument.getAsInt()));
    }

}