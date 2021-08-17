package com.bridgelabz.addressbook.constant;

public enum ExceptionConstant {
  ID_NOT_FOUND("Id not found");

  private String message;

  ExceptionConstant(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
