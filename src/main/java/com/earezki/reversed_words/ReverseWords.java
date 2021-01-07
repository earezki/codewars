package com.earezki.reversed_words;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class ReverseWords {

    static class Sentence {
        private static final String DELIMITER = " ";

        private final List<String> words;

        Sentence(String sentence) {
            this.words = List.of(sentence.split(DELIMITER));
        }

        String reversed() {
            Supplier<List<String>> reversed = () -> {
                List<String> result = new ArrayList<>(words);
                Collections.reverse(
                        result
                );
                return result;
            };

            return String.join(
                    DELIMITER,
                    reversed.get()
            );
        }

    }

    public static String reverseWords(String input) {
        if (input == null || input.isBlank()) {
            return "";
        }

        Sentence sentence =  new Sentence(input);
        return sentence.reversed();
    }

}