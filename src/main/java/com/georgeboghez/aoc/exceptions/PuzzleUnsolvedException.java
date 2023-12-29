package com.georgeboghez.aoc.exceptions;

import com.georgeboghez.aoc.enums.Part;
import com.georgeboghez.aoc.enums.PuzzleStatusEnum;

public class PuzzleUnsolvedException extends RuntimeException {
  public PuzzleUnsolvedException(int day, Part part, PuzzleStatusEnum status) {
    super("The puzzle for day " + day + " " + buildPartMessage(part) + " has status: " + status.name());
  }

  public PuzzleUnsolvedException(int day, Part part, PuzzleStatusEnum status, String message) {
    super("The puzzle for day " + day + " " + buildPartMessage(part) + " has status: " + status.name() + " (due to error - " + message + ")");
  }

  private static String buildPartMessage(Part part) {
    return switch (part) {
      case FIRST -> "part 1";
      case SECOND -> "part 2";
      case BOTH -> "both parts";
    };
  }
}
