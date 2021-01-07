package com.earezki.reversed_words;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsTest {

    @Test
    void testSomething() {
        assertEquals("eating like I", ReverseWords.reverseWords("I like eating"));
        assertEquals("flying like I", ReverseWords.reverseWords("I like flying"));
        assertEquals("nice is world The", ReverseWords.reverseWords("The world is nice"));
    }

}