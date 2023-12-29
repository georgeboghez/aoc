package com.georgeboghez.aoc.days.day1.utils;

@FunctionalInterface
public interface DigitsFinder {
  Long findFirstDigitAndLastDigit(String line);
}
