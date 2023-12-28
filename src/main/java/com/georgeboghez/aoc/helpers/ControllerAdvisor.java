package com.georgeboghez.aoc.helpers;

import com.georgeboghez.aoc.exception.BadArgumentException;
import com.georgeboghez.aoc.exception.PuzzleUnsolvedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ControllerAdvisor {

  @ExceptionHandler(value = {PuzzleUnsolvedException.class})
  public ResponseEntity<ErrorMessage> puzzleNotSolvedYetException(PuzzleUnsolvedException e) {

    return new ResponseEntity<>(
        new ErrorMessage(HttpStatus.NOT_FOUND.value(), e.getMessage()),
        HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class, BadArgumentException.class})
  public ResponseEntity<ErrorMessage> methodArgumentTypeMismatchException(Throwable e) {

    return new ResponseEntity<>(
        new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
        HttpStatus.BAD_REQUEST);
  }
}
