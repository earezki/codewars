package com.earezki.greed_is_good;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Greed {

    static class Score {
        private static final int JACKPOT = 3;

        private static final Map<Integer, Integer> JACKPOT_SCORES = Map.of(
                6, 600,
                5, 500,
                4, 400,
                3, 300,
                2, 200,
                1, 1000
        );

        private static final Map<Integer, Integer> SINGLE_SCORES = Map.of(
                1, 100,
                5, 50
        );

        int scoreOf(List<DiceFace> diceFaces) {
            Map<Integer, Integer> facesOccurrence = diceFaces.stream()
                    .collect(groupingBy(DiceFace::asInt, summingInt(x -> 1)));

            return facesOccurrence.entrySet().stream()
                    .mapToInt(result -> scoreOf(result.getKey(), result.getValue()))
                    .sum();
        }

        private int scoreOf(int faceNumber, int occurrence) {
            int jackpotsOccurrences = (occurrence / JACKPOT);
            int nonJackpotOccurrences = (occurrence % JACKPOT);

            return (jackpotsOccurrences * JACKPOT_SCORES.getOrDefault(faceNumber, 0)) +
                    (nonJackpotOccurrences * SINGLE_SCORES.getOrDefault(faceNumber, 0));
        }

    }

    static class DiceFace {
        private final int value;

        DiceFace(int value) {
            this.value = value;
        }

        public int asInt() {
            return value;
        }
    }

    public static int greedy(int[] dice) {
        List<DiceFace> diceFaces = IntStream.of(dice)
                .mapToObj(DiceFace::new)
                .collect(toList());

        Score score = new Score();

        return score.scoreOf(diceFaces);
    }
}
