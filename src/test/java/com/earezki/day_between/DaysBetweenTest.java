package com.earezki.day_between;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DaysBetweenTest {

    @Test
    void daysBetween() {

        Stream<LocalDate> dates = DaysBetween.daysBetween(
                LocalDate.of(2022, 1, 1),
                LocalDate.of(3000, 1, 10)
        );


        System.out.println(
                dates
                        .limit(20)
                        .collect(Collectors.toList())
        );

    }

}