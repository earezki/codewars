package com.earezki.word_to_initial_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    void convert_test0() {
        int R = 10234567;
        String s = "CodeWars";

        assertEquals(R, Converter.convert(s));
    }

    @Test
    void convert_test1() {
        int R = 1020;
        String s = "KATA";

        assertEquals(R, Converter.convert(s));
    }

    @Test
    void convert_test2() {
        int R = 101;
        String s = "ABA";

        assertEquals(R, Converter.convert(s));
    }

    @Test
    void convert_test3() {
        int R = 1;
        String s = "A";

        assertEquals(R, Converter.convert(s));
    }

    @Test
    void convert_test4() {
        int R = 111;
        String s = "AaA";

        assertEquals(R, Converter.convert(s));
    }

}