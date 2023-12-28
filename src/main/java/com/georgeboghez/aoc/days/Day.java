package com.georgeboghez.aoc.days;

import com.georgeboghez.aoc.dto.DaySolutionDto;
import com.georgeboghez.aoc.enums.Part;
import com.georgeboghez.aoc.enums.PuzzleStatusEnum;

public abstract class Day {
  public static final int MIN_ADVENT_OF_CODE_DAY = 1;
  public static final int MAX_ADVENT_OF_CODE_DAY = 25;


  public abstract DaySolutionDto getFirstPartSolution();

  public abstract DaySolutionDto getSecondPartSolution();

  public abstract int getDayNumber();

  public DaySolutionDto getDaySolution() {
    return new DaySolutionDto(getDayNumber(), getDayStatus(getFirstPartSolution(), getSecondPartSolution()));
  }

  public static PuzzleStatusEnum getDayStatus(DaySolutionDto firstPartSolution, DaySolutionDto secondPartSolution) {
    if (isPartSolved(firstPartSolution) && isPartSolved(secondPartSolution)) {
      return PuzzleStatusEnum.SOLVED;
    }

    if (isPartSolved(firstPartSolution)) {
      return PuzzleStatusEnum.ONLY_FIRST_PART_SOLVED;
    }

    if (isPartSolved(secondPartSolution)) {
      return PuzzleStatusEnum.ONLY_SECOND_PART_SOLVED;
    }

    return PuzzleStatusEnum.UNSOLVED;
  }

  private static boolean isPartSolved(DaySolutionDto daySolution) {
    return daySolution != null && PuzzleStatusEnum.SOLVED.equals(daySolution.getPuzzleStatus());
  }

  public boolean isPuzzleSolvedForPart(Part part) {
    return switch (part) {
      case FIRST -> isPartSolved(getFirstPartSolution());
      case SECOND -> isPartSolved(getSecondPartSolution());
      case BOTH -> isPartSolved(getDaySolution());
    };
  }
}
