package com.earezki.up_and_down;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Updown {

    public static String arrange(String param) {
        Text text = new Text(param);

        return text.arrange();
    }

    static class Text {

        public static final String PHRASE_DELIMITER = " ";
        public static final int HEAD_INDEX = 0;
        public static final int NEXT_INDEX = 1;

        private final String value;

        public Text(String text) {
            this.value = text;
        }

        List<Phrase> phrases() {
            return Stream.of(value.split(PHRASE_DELIMITER))
                    .map(Phrase::new)
                    .collect(collectingAndThen(toList(), LinkedList::new));
        }

        public String arrange() {
            List<Phrase> phrases = phrases();
            List<Phrase> result = new ArrayList<>();

            boolean isLowerThan = true;

            while (!phrases.isEmpty()) {
                Phrase nextPhrase = nextPhrase(phrases, isLowerThan);

                result.add(nextPhrase);
                phrases.remove(nextPhrase);

                isLowerThan = !isLowerThan;
            }

            return upDown(result);
        }

        private Phrase nextPhrase(List<Phrase> phrases, boolean isLowerThan) {
            Phrase head = phrases.get(HEAD_INDEX);
            if (hasNext(phrases)) {
                Phrase next = phrases.get(NEXT_INDEX);
                if (head.over(next, isLowerThan)) {
                    return head;
                } else {
                    return next;
                }
            }
            return head;
        }

        private boolean hasNext(List<Phrase> phrases) {
            return phrases.size() > NEXT_INDEX;
        }

        private String upDown(List<Phrase> result) {
            return IntStream.range(0, result.size())
                    .mapToObj(index -> result.get(index).switchCase(index))
                    .collect(Collectors.joining(PHRASE_DELIMITER));
        }
    }

    static class Phrase {

        private final String value;

        Phrase(String value) {
            this.value = value;
        }

        String switchCase(int inTextIndex) {
            return inTextIndex % 2 == 0 ? value.toLowerCase() : value.toUpperCase();
        }

        boolean over(Phrase next, boolean isLowerThan) {
            return (isLowerThan && this.value.length() <= next.value.length()) ||
                    (!isLowerThan && next.value.length() <= this.value.length());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Phrase phrase = (Phrase) o;
            return Objects.equals(value, phrase.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

}
