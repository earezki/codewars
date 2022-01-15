package com.earezki.remove_consecutive_duplicate_words;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicateConsecutiveWordsTest {

    String s1 = "alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta";
    String ans1 = "alpha beta gamma delta alpha beta gamma delta";
    String s2 = "cyqje cyqje cyqje a a a";
    String ans2 = "cyqje a";

    @Test
    void basicTest(){
        assertEquals(ans1, RemoveDuplicateConsecutiveWords.removeConsecutiveDuplicates(s1), "For input \"" + s1 + "\"");
        assertEquals(ans2, RemoveDuplicateConsecutiveWords.removeConsecutiveDuplicates(s2), "For input \"" + s2 + "\"");
        assertEquals("", RemoveDuplicateConsecutiveWords.removeConsecutiveDuplicates(""), "For input \"" + "" + "\"");
        assertEquals("word", RemoveDuplicateConsecutiveWords.removeConsecutiveDuplicates("word"), "For input \"" + "word" + "\"");
        assertEquals("a ab", RemoveDuplicateConsecutiveWords.removeConsecutiveDuplicates("a a ab"), "For input \"" + "a a ab" + "\"");
    }

}