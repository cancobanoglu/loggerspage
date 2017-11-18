package com.loggerspage.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by caniven on 18/11/2017.
 */
public class Violation {

  @JsonProperty("inputName")
  private String inputName;

  @JsonProperty("message")
  private String message;

  public String getInputName() {
    return inputName;
  }

  public void setInputName(String inputName) {
    this.inputName = inputName;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}