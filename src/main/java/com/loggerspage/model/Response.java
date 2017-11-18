package com.loggerspage.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Created by caniven on 18/11/2017.
 */

public class Response<T> {
  @JsonProperty("meta")
  private ResponseMeta meta = null;

  @JsonProperty("response")
  private T response = null;

  public Response meta(ResponseMeta meta) {
    this.meta = meta;
    return this;
  }

  /**
   * Get meta
   *
   * @return meta
   **/
  public ResponseMeta getMeta() {
    return meta;
  }

  public void setMeta(ResponseMeta meta) {
    this.meta = meta;
  }

  /**
   * Response body
   *
   * @return response
   **/

  public T getResponse() {
    return response;
  }

  public void setResponse(T response) {
    this.response = response;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response response = (Response) o;
    return Objects.equals(this.meta, response.meta) &&
        Objects.equals(this.response, response.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meta, response);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response {\n");

    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
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
