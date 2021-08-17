package com.bridgelabz.addressbook.exception;

import com.bridgelabz.addressbook.constant.ExceptionConstant;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseDTO> globalExceptionHandler(Exception ex) {
    return new ResponseEntity<>(new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ResponseDTO> customExceptionHandler(Exception ex) {
    return new ResponseEntity<>(new ResponseDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null),
        HttpStatus.BAD_REQUEST);
  }
}
