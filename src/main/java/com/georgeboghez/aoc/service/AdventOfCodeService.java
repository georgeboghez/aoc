package com.georgeboghez.aoc.service;

import com.georgeboghez.aoc.days.Day;
import com.georgeboghez.aoc.enums.Part;
import com.georgeboghez.aoc.enums.PuzzleStatusEnum;
import com.georgeboghez.aoc.exception.PuzzleUnsolvedException;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Service
@AllArgsConstructor
public class AdventOfCodeService {

  private final List<Day> days;


  public String getResultsForASpecificDayAndPuzzlePart(int dayNumber, Part part) {
    Day day = findSolutionForDay(dayNumber, part);
    if (!day.isPuzzleSolvedForPart(part)) {
      throw new PuzzleUnsolvedException(dayNumber, part, PuzzleStatusEnum.UNSOLVED);
    }

    return switch (part) {
      case FIRST -> day.getFirstPartSolution();
      case SECOND -> day.getSecondPartSolution();
      case BOTH -> day.getFirstPartSolution() + ' ' + day.getSecondPartSolution();
    };
  }

  private Day findSolutionForDay(int dayNumber, Part part) {
    if (dayNumber < Day.MIN_ADVENT_OF_CODE_DAY || dayNumber > Day.MAX_ADVENT_OF_CODE_DAY) {
      throw new PuzzleUnsolvedException(dayNumber, part, PuzzleStatusEnum.NONEXISTENT);
    }
    return this.days.stream()
        .filter(solution -> solution.getDayNumber() == dayNumber)
        .findFirst()
        .orElseThrow(() -> new PuzzleUnsolvedException(dayNumber, part, PuzzleStatusEnum.UNSOLVED));
  }

}
