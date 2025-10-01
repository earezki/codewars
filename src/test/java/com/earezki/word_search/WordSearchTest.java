package com.earezki.word_search;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {

    @Test
    void exist_x1() {
        WordSearch sut = new WordSearch();

        // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        assertTrue(
                sut.exist(
                        new char[][] {
                                {'A','B','C','E'},
                                {'S','F','C','S'},
                                {'A','D','E','E'}
                        },
                        "ABCCED"
                )
        );
    }

    @Test
    void exist_x2() {
        WordSearch sut = new WordSearch();

        // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        assertTrue(
                sut.exist(
                        new char[][] {
                                {'A','B','C','E'},
                                {'S','F','C','S'},
                                {'A','D','E','E'}
                        },
                        "SEE"
                )
        );

    }

    @Test
    void exist_x3() {
        WordSearch sut = new WordSearch();

        //[["a","b"],["c","d"]]
        assertTrue(
                sut.exist(
                        new char[][] {
                                {'a','b'},
                                {'c','d'}
                        },
                        "acdb"
                )
        );
    }

    @Test
    void exist_x4() {
        WordSearch sut = new WordSearch();

        // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        assertFalse(
                sut.exist(
                        new char[][] {
                                {'A','B','C','E'},
                                {'S','F','C','S'},
                                {'A','D','E','E'}
                        },
                        "ABCB"
                )
        );

    }

    @Test
    void exist_x5() {
        WordSearch sut = new WordSearch();

        // [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
        assertTrue(
                sut.exist(
                        new char[][] {
                                {'A','B','C','E'},
                                {'S','F','E','S'},
                                {'A','D','E','E'}
                        },
                        "ABCESEEEFS"
                )
        );

    }

    @Test
    void find_words_x1() {
        WordSearch sut = new WordSearch();

        // [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
        List<String> expected = Arrays.asList("oath", "eat");
        assertEquals(
                expected,
                sut.findWords(
                        new char[][]{
                                {'o', 'a', 'a', 'n'},
                                {'e', 't', 'a', 'e'},
                                {'i', 'h', 'k', 'r'},
                                {'i', 'f', 'l', 'v'}
                        },
                        new String[]{"oath", "pea", "eat", "rain"}
                )
        );
    }

}