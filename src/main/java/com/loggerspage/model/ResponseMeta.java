package com.loggerspage.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * Created by caniven on 18/11/2017.
 */

public class ResponseMeta {
  @JsonProperty("code")
  private Integer code;

  @JsonProperty("message")
  private String message;

  @JsonProperty("violationList")
  private List<Violation> violationList;

  public ResponseMeta code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Response code, 0 if successful
   *
   * @return code
   **/
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public ResponseMeta message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Response violationList
   *
   * @return violationList
   **/
  public List<Violation> getViolationList() {
    return violationList;
  }

  public void setViolationList(List<Violation> violationList) {
    this.violationList = violationList;
  }

  public ResponseMeta violationList(List<Violation> violationList) {
    this.violationList = violationList;
    return this;
  }

  /**
   * Response message, null if code is 0
   *
   * @return message
   **/
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseMeta responseMeta = (ResponseMeta) o;
    return Objects.equals(this.code, responseMeta.code) &&
        Objects.equals(this.message, responseMeta.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseMeta {\n");

    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}