package com.georgeboghez.aoc.helpers;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
  private int statusCode;
  private LocalDateTime timestamp;
  private String message;

  ErrorMessage(int statusCode, String message) {
    this.statusCode = statusCode;
    this.timestamp = LocalDateTime.now();
    this.message = message;
  }
}

