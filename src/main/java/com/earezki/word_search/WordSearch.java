package com.earezki.word_search;

import java.util.*;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int row, int col) {
        if (idx == word.length()) return true; // all chars matched

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || board[row][col] != word.charAt(idx)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#'; // mark visited

        boolean found = dfs(board, word, idx + 1, row + 1, col)
                || dfs(board, word, idx + 1, row - 1, col)
                || dfs(board, word, idx + 1, row, col + 1)
                || dfs(board, word, idx + 1, row, col - 1);

        board[row][col] = temp; // backtrack for next path.

        return found;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                result.add(word);
            }
        }
        return result;
    }

}
