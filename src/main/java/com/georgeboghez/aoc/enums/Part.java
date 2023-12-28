package com.georgeboghez.aoc.enums;

import com.georgeboghez.aoc.exception.BadArgumentException;

import lombok.Getter;

@Getter
public enum Part {
  FIRST(1),
  SECOND(2),
  BOTH(0);

  private final int value;

  Part(int value) {
    this.value = value;
  }

  public static Part fromValue(String value) {
    return switch (value) {
      case "1", "first", "FIRST" -> FIRST;
      case "2", "second", "SECOND" -> SECOND;
      case "0", "both", "BOTH" -> BOTH;
      default -> throw new BadArgumentException("Unexpected value for 'part' request param: " + value);
    };
  }
}
