package io.devynlab.employeeapp.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
  @ExceptionHandler({IllegalArgumentException.class, MissingServletRequestParameterException.class, HttpMessageNotReadableException.class})
  public ResponseEntity<ErrorResponse> handleBadRequest(Exception e, HttpServletRequest request) {
    ErrorResponse errorResponse = ErrorResponse.builder()
        .status(HttpStatus.BAD_REQUEST)
        .code(HttpStatus.BAD_REQUEST.value())
        .message(e.getMessage())
        .uri(request.getRequestURL().toString())
        .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<ErrorResponse> handleConflict(DataIntegrityViolationException e, HttpServletRequest request) {
    ErrorResponse errorResponse = ErrorResponse.builder()
        .status(HttpStatus.CONFLICT)
        .code(HttpStatus.CONFLICT.value())
        .message(e.getMessage())
        .uri(request.getRequestURL().toString())
        .build();
    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException e, HttpServletRequest request) {
    ErrorResponse errorResponse = ErrorResponse.builder()
        .status(HttpStatus.NOT_FOUND)
        .code(HttpStatus.NOT_FOUND.value())
        .message(e.getMessage())
        .uri(request.getRequestURL().toString())
        .build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }
}