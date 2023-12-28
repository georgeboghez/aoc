package com.georgeboghez.aoc.days;

import com.georgeboghez.aoc.enums.Part;

public abstract class Day {
  public static final int MIN_ADVENT_OF_CODE_DAY = 1;
  public static final int MAX_ADVENT_OF_CODE_DAY = 25;

  public abstract String getFirstPartSolution();

  public abstract String getSecondPartSolution();

  public abstract int getDayNumber();

  public boolean isPuzzleSolvedForPart(Part part) {
    return switch (part) {
      case FIRST -> getFirstPartSolution() != null;
      case SECOND -> getSecondPartSolution() != null;
      case BOTH -> getFirstPartSolution() != null && getSecondPartSolution() != null;
    };
  }
}
