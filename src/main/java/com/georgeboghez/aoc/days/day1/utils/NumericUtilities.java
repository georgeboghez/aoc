package com.georgeboghez.aoc.days.day1.utils;

import java.util.Optional;

public class NumericUtilities {

  private NumericUtilities() {
  }

  public static Long concatenateLongs(Long firstDigit, Long lastDigit) {
    if (firstDigit == null) {
      return 0L;
    }
    return Long.valueOf(String.valueOf(firstDigit) + lastDigit);
  }

  public static Optional<Long> extractLongIfCharIsDigit(char character) {
    if (Character.isDigit(character)) {
      return Optional.of(Long.parseLong(String.valueOf(character)));
    }
    return Optional.empty();
  }

  public static Optional<Long> extractLongIfWordIsDigit(String word) {
    String lowerCase = word.toLowerCase();
    if (lowerCase.endsWith("one")) {
      return Optional.of(1L);
    } else if (lowerCase.endsWith("two")) {
      return Optional.of(2L);
    } else if (lowerCase.endsWith("three")) {
      return Optional.of(3L);
    } else if (lowerCase.endsWith("four")) {
      return Optional.of(4L);
    } else if (lowerCase.endsWith("five")) {
      return Optional.of(5L);
    } else if (lowerCase.endsWith("six")) {
      return Optional.of(6L);
    } else if (lowerCase.endsWith("seven")) {
      return Optional.of(7L);
    } else if (lowerCase.endsWith("eight")) {
      return Optional.of(8L);
    } else if (lowerCase.endsWith("nine")) {
      return Optional.of(9L);
    }
    return Optional.empty();
  }
}
