package com.georgeboghez.aoc.exceptions;

import com.georgeboghez.aoc.enums.Part;
import com.georgeboghez.aoc.enums.PuzzleStatusEnum;

public class PuzzleUnsolvedException extends RuntimeException {
  public PuzzleUnsolvedException(int day, Part part, PuzzleStatusEnum status) {
    super("The puzzle for day " + day + " " + getPartMessage(part) + " has status: " + status.name());
  }

  private static String getPartMessage(Part part) {
    return switch (part) {
      case FIRST -> "part 1";
      case SECOND -> "part 2";
      case BOTH -> "both parts";
    };
  }
}
