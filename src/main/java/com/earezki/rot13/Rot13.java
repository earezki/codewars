package com.earezki.rot13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rot13 {

    static int ROT_13_DIST = 13;
    static Map<Character, Character> ROT_13_DICT = new HashMap<>();

    public static final int ALPHABETS = 26;

    static {
        for (char c : List.of('a', 'A')) {
            for (int i = c, j = 0; i <= c + ROT_13_DIST; i++, j++) {
                // [a-m][A-m] => [n-z][N-z]
                int nextEncoding = c + ROT_13_DIST;
                ROT_13_DICT.put((char) i, (char) (nextEncoding + j));
            }
            for (int i = c + ROT_13_DIST, j = 0; i <= c + ALPHABETS; i++, j++) {
                // [n-z][N-Z] => [a-n][A-N]
                ROT_13_DICT.put((char) i, (char) (c + j));
            }
        }
    }

    public static String rot13(String message) {
        return message.chars()
                .mapToObj(ascii -> String.valueOf(ROT_13_DICT.getOrDefault((char) ascii, (char) ascii)))
                .collect(Collectors.joining());
    }

}
