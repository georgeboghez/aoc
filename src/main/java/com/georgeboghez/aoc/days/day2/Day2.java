package com.georgeboghez.aoc.days.day2;

import com.georgeboghez.aoc.days.Day;
import com.georgeboghez.aoc.dto.DaySolutionDto;
import com.georgeboghez.aoc.enums.Part;
import com.georgeboghez.aoc.enums.PuzzleStatusEnum;
import com.georgeboghez.aoc.exceptions.PuzzleUnsolvedException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day2 extends Day {
  @Override
  public DaySolutionDto solveFirstPart() {
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
