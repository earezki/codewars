package com.earezki.up_and_down;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdownTest {

    @Test
    void test_1() {
        assertEquals("who RETAINING hit THAT a THE we TAKEN", Updown.arrange("who hit retaining The That a we taken"));
    }

    @Test
    void test_2() {
        assertEquals("i CAME on WERE up GRANDMOTHERS so", Updown.arrange("on I came up were so grandmothers"));
    }

    @Test
    void test_3() {
        assertEquals("way THE my WALL him THEM", Updown.arrange("way the my wall them him"));
    }

}