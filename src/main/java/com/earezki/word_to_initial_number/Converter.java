package com.earezki.word_to_initial_number;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntUnaryOperator;

class Converter {

    static class Word {
        private static final int DEFAULT_NUMBER = 0;
        private static final int INITIAL_LETTER = 1;
        private static final int ONE_ELEMENT = 1;

        private final String value;

        Word(String value) {
            if (value == null || value.isBlank()) {
                throw new IllegalArgumentException("Value cannot be blank !");
            }

            this.value = value.toLowerCase();
        }

        long toNumber() {
            Map<Character, Integer> letterToNumber = letterToNumber();

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < value.length(); i++) {
                char letter = letter(i);
                result.append(letterToNumber.get(letter));
            }

            return Long.parseLong(result.toString());
        }

        private Map<Character, Integer> letterToNumber() {
            Map<Character, Integer> letterToNumber = new HashMap<>();

            letterToNumber.put(letter(DEFAULT_NUMBER), INITIAL_LETTER);
            for (int i = INITIAL_LETTER; i < value.length(); i++) {
                char letter = letter(i);
                if (!letterToNumber.containsKey(letter)) {
                    int nextNumber = nextNumber(letterToNumber);
                    letterToNumber.put(letter, nextNumber);
                }
            }
            return letterToNumber;
        }

        private char letter(int index) {
            return value.charAt(index);
        }

        private int nextNumber(Map<Character, Integer> letterToNumber) {
            Collection<Integer> numbers = letterToNumber.values();
            if (numbers.size() == ONE_ELEMENT) {
                return DEFAULT_NUMBER;
            }

            IntUnaryOperator nextNumber = x -> x + 1;
            return numbers
                    .stream()
                    .mapToInt(x -> x)
                    .map(nextNumber)
                    .max()
                    .orElse(DEFAULT_NUMBER);
        }
    }

    public static long convert(String word) {
        if (word == null || word.isBlank()) {
            return 0;
        }

        Word w = new Word(word);
        return w.toNumber();
    }

}