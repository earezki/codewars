package com.earezki.auto_complete;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AutocompleteSystemTest {

    private AutocompleteSystem acs;

    @Test
    void test_1() {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        acs = new AutocompleteSystem(sentences, times);

        List<String> result1 = acs.input('i');
        assertEquals(List.of("i love you", "island", "i love leetcode"), result1);

        List<String> result2 = acs.input(' ');
        assertEquals(List.of("i love you", "i love leetcode"), result2);

        List<String> result3 = acs.input('a');
        assertTrue(result3.isEmpty());

        List<String> result4 = acs.input('#');
        assertTrue(result4.isEmpty());
    }

    @Test
    void test_2() {
        String[] sentences = {"hello world"};
        int[] times = {10};
        acs = new AutocompleteSystem(sentences, times);

        // Input a new sentence "hello there#"
        acs.input('h');
        acs.input('e');
        acs.input('l');
        acs.input('l');
        acs.input('o');
        acs.input(' ');
        acs.input('t');
        acs.input('h');
        acs.input('e');
        acs.input('r');
        acs.input('e');
        List<String> resultAfterHash = acs.input('#');
        assertTrue(resultAfterHash.isEmpty());

        // Now search for "hello"
        List<String> suggestions = acs.input('h');
        suggestions = acs.input('e');
        suggestions = acs.input('l');
        suggestions = acs.input('l');
        suggestions = acs.input('o');

        // Both "hello world" and "hello there" should be suggestions.
        // "hello world" has a higher frequency, so it comes first.
        assertEquals(List.of("hello world", "hello there"), suggestions);
    }

    @Test
    void test_3() {
        String[] sentences = {"java", "javascript"};
        int[] times = {5, 3};
        acs = new AutocompleteSystem(sentences, times);

        // Input "java#" to increment its count
        acs.input('j');
        acs.input('a');
        acs.input('v');
        acs.input('a');
        acs.input('#');

        // Now, "java" should have a count of 6. Let's verify by searching again.
        List<String> suggestions = acs.input('j');
        suggestions = acs.input('a');

        // "java" should still be first due to its higher updated frequency.
        assertEquals(List.of("java", "javascript"), suggestions);
    }

    @Test
    void test_4() {
        String[] sentences = {"cat", "dog", "car"};
        int[] times = {5, 4, 6};
        acs = new AutocompleteSystem(sentences, times);

        List<String> result = acs.input('z');
        assertTrue(result.isEmpty());
    }

    @Test
    void test_5() {
        // "apple" and "apply" have the same frequency. "apple" should come first.
        String[] sentences = {"apply", "apple", "ape"};
        int[] times = {5, 5, 3};
        acs = new AutocompleteSystem(sentences, times);

        List<String> suggestions = acs.input('a');
        suggestions = acs.input('p');

        assertEquals(List.of("apple", "apply", "ape"), suggestions);
    }
}