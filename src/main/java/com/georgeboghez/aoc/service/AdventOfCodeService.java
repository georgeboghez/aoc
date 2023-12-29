package com.georgeboghez.aoc.service;

import com.georgeboghez.aoc.days.Day;
import com.georgeboghez.aoc.days.day1.Day1;
import com.georgeboghez.aoc.days.day2.Day2;
import com.georgeboghez.aoc.dto.DaySolutionDto;
import com.georgeboghez.aoc.enums.Part;
import com.georgeboghez.aoc.enums.PuzzleStatusEnum;
import com.georgeboghez.aoc.exceptions.PuzzleUnsolvedException;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Service
@AllArgsConstructor
public class AdventOfCodeService {

  private final List<Day> days = List.of(new Day1(), new Day2());

  public DaySolutionDto solvePuzzleForASpecificDayAndPart(int dayNumber, Part part) {
    Day day = findSolutionForDay(dayNumber, part);
    if (!day.isPuzzleSolvedForPart(part)) {
      throw new PuzzleUnsolvedException(dayNumber, part, PuzzleStatusEnum.UNSOLVED);
    }

    return switch (part) {
      case FIRST -> day.solveFirstPart();
      case SECOND -> day.solveSecondPart();
      case BOTH -> day.solveBothParts();
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
