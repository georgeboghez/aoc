package com.georgeboghez.aoc.days.day1;

import com.georgeboghez.aoc.days.Day;
import com.georgeboghez.aoc.days.day1.utils.DigitsFinder;
import com.georgeboghez.aoc.days.day1.utils.impl.DigitsFinderImpl;
import com.georgeboghez.aoc.days.day1.utils.impl.DigitsFinderIncludingWordsImpl;
import com.georgeboghez.aoc.dto.DaySolutionDto;
import com.georgeboghez.aoc.enums.Part;
import com.georgeboghez.aoc.enums.PuzzleStatusEnum;
import com.georgeboghez.aoc.exceptions.PuzzleUnsolvedException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day1 extends Day {
  @Override
  public DaySolutionDto solveFirstPart() {
    String inputFilePath = "src/main/java/com/georgeboghez/aoc/days/day1/input.txt";
    DigitsFinder digitsFinder = new DigitsFinderImpl();
    return solvePart(inputFilePath, digitsFinder);
  }

  @Override
  public DaySolutionDto solveSecondPart() {
    String inputFilePath = "src/main/java/com/georgeboghez/aoc/days/day1/input2.txt";
    DigitsFinder digitsFinder = new DigitsFinderIncludingWordsImpl();
    return solvePart(inputFilePath, digitsFinder);
  }

  private DaySolutionDto solvePart(String filePath, DigitsFinder digitsFinder) {
    long sum = 0L;
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        Long firstDigitAndLastDigit = digitsFinder.findFirstDigitAndLastDigit(line);
        sum += firstDigitAndLastDigit;
      }
    } catch (IOException e) {
      log.error("Failed to read file line by line", e);
      throw new PuzzleUnsolvedException(getDayNumber(), Part.FIRST, PuzzleStatusEnum.UNSOLVED, e.getMessage());
    }
    return new DaySolutionDto(getDayNumber(), String.valueOf(sum), PuzzleStatusEnum.SOLVED);
  }

  @Override
  public int getDayNumber() {
    return 1;
  }
}
