package com.georgeboghez.aoc.days.day2;

import com.georgeboghez.aoc.days.Day;
import com.georgeboghez.aoc.days.day2.utils.GameSolver;
import com.georgeboghez.aoc.days.day2.utils.impl.GameSolverImpl;
import com.georgeboghez.aoc.dto.DaySolutionDto;
import com.georgeboghez.aoc.enums.Part;
import com.georgeboghez.aoc.enums.PuzzleStatusEnum;
import com.georgeboghez.aoc.exceptions.PuzzleUnsolvedException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day2 extends Day {
  @Override
  public DaySolutionDto solveFirstPart() {
    String inputFilePath = "src/main/java/com/georgeboghez/aoc/days/day2/input.txt";
    GameSolver digitsFinder = new GameSolverImpl();
    long sum = 0L;
    try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        Long firstDigitAndLastDigit = digitsFinder.solveGame(line);
        sum += firstDigitAndLastDigit;
      }
    } catch (IOException e) {
      log.error("Failed to read file line by line", e);
      throw new PuzzleUnsolvedException(getDayNumber(), Part.FIRST, PuzzleStatusEnum.UNSOLVED, e.getMessage());
    }
//    new DaySolutionDto(getDayNumber(), String.valueOf(sum), PuzzleStatusEnum.SOLVED);
    throw new PuzzleUnsolvedException(getDayNumber(), Part.FIRST, PuzzleStatusEnum.IN_PROGRESS);
  }

  @Override
  public DaySolutionDto solveSecondPart() {
    return null;
  }

  @Override
  public int getDayNumber() {
    return 2;
  }
}
