package com.georgeboghez.aoc.controller;

import com.georgeboghez.aoc.days.Day;
import com.georgeboghez.aoc.enums.Part;
import com.georgeboghez.aoc.service.AdventOfCodeService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/advent-of-code", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class AdventOfCodeController {

  private final AdventOfCodeService adventOfCodeService;

  @GetMapping
  public String getResultForASpecificDayAndPuzzlePart(@RequestParam(value = "day", defaultValue = "1") int day, @RequestParam(value = "part", defaultValue = "BOTH") String partValue) {
    Part part = Part.fromValue(partValue);
    log.info("The results for day {}, part {} have been requested.", day, part.getValue());
    return adventOfCodeService.getResultsForASpecificDayAndPuzzlePart(day, part);
  }

  @GetMapping("/days-implemented")
  public List<Integer> daysImplemented() {
    log.info("The list of implemented days has been requested.");
    return adventOfCodeService.getDays().stream()
        .map(Day::getDayNumber)
        .sorted()
        .toList();
  }
}
