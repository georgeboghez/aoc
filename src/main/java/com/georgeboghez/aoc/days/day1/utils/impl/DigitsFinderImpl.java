package com.georgeboghez.aoc.days.day1.utils.impl;

import com.georgeboghez.aoc.days.day1.utils.DigitsFinder;
import com.georgeboghez.aoc.days.day1.utils.NumericUtilities;

import java.util.Optional;

public class DigitsFinderImpl implements DigitsFinder {
  @Override
  public Long findFirstDigitAndLastDigit(String line) {
    char[] characters = line.toCharArray();
    Long firstDigit = null;
    Long lastDigit = null;
    for (char character : characters) {
      Optional<Long> digitOpt = NumericUtilities.extractLongIfCharIsDigit(character);
      if (digitOpt.isEmpty()) {
        continue;
      }
      Long digit = digitOpt.get();
      if (firstDigit == null) {
        firstDigit = digit;
      }
      lastDigit = digit;
    }
    return NumericUtilities.concatenateLongs(firstDigit, lastDigit);
  }
}
