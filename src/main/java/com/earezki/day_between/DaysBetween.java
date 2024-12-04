package com.earezki.day_between;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class DaysBetween {

    public static Stream<LocalDate> daysBetween(LocalDate start, LocalDate end) {
        return Stream.iterate(start, current -> !end.isBefore(current), current -> current.plusDays(1));
    }

}
