package com.georgeboghez.aoc.days.day1.utils.impl;

import static com.georgeboghez.aoc.days.day1.utils.NumericUtilities.extractLongIfCharIsDigit;

import com.georgeboghez.aoc.days.day1.utils.DigitsFinder;
import com.georgeboghez.aoc.days.day1.utils.NumericUtilities;

import java.util.Optional;

public class DigitsFinderIncludingWordsImpl implements DigitsFinder {
  @Override
  public Long findFirstDigitAndLastDigit(String line) {
    char[] characters = line.toCharArray();
    Long firstDigit = null;
    Long lastDigit = null;
    StringBuilder word = new StringBuilder();
    for (char character : characters) {
      if (Character.isAlphabetic(character)) {
        word.append(character);
        Optional<Long> digitOpt = NumericUtilities.extractLongIfWordIsDigit(word.toString());
        if (digitOpt.isPresent()) {
          Long digit = digitOpt.get();
          if (firstDigit == null) {
            firstDigit = digit;
          }
          lastDigit = digit;
        }
      } else {
        word = new StringBuilder();
        Optional<Long> digitOpt = extractLongIfCharIsDigit(character);
        if (digitOpt.isPresent()) {
          Long digit = digitOpt.get();
          if (firstDigit == null) {
            firstDigit = digit;
          }
          lastDigit = digit;
        }
      }
    }
    return NumericUtilities.concatenateLongs(firstDigit, lastDigit);
  }
}
