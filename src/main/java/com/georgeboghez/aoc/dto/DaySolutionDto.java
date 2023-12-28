package com.georgeboghez.aoc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.georgeboghez.aoc.enums.PuzzleStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DaySolutionDto {
  private int day;
  private String solution;
  private PuzzleStatusEnum puzzleStatus;

  public DaySolutionDto(int day, PuzzleStatusEnum puzzleStatus) {
    this.day = day;
    this.puzzleStatus = puzzleStatus;
  }
}
