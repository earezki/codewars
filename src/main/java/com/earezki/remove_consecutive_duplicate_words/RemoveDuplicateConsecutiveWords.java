package com.earezki.remove_consecutive_duplicate_words;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RemoveDuplicateConsecutiveWords {

    static class Word {
        private final String value;

        Word(String value) {
            this.value = value;
        }

        String asString() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word = (Word) o;
            return Objects.equals(value, word.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    static class WordsParser {

        List<Word> words(String input) {
            Pattern pattern = Pattern.compile(" ");
            return pattern.splitAsStream(input)
                    .map(Word::new)
                    .collect(toList());
        }

    }

    static class UniqueConsecutiveWords {

        private final List<Word> words = new ArrayList<>();

        public UniqueConsecutiveWords(List<Word> words) {
            words.forEach(this::add);
        }

        private void add(Word word) {
            if (isNotLastElement(word)) {
                this.words.add(word);
            }
        }

        private boolean isNotLastElement(Word word) {
            return words.isEmpty() || !words.get(words.size() - 1).equals(word);
        }

        String format() {
            return words.stream()
                    .map(Word::asString)
                    .collect(joining(" "));
        }
    }

    public static String removeConsecutiveDuplicates(String input) {
        WordsParser parser = new WordsParser();
        List<Word> words = parser.words(input);

        UniqueConsecutiveWords uniqueConsecutiveWords = new UniqueConsecutiveWords(words);

        return uniqueConsecutiveWords.format();
    }

}
