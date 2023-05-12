package io.devynlab.employeeapp.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorResponse {
  @JsonProperty("status")
  private HttpStatus status;

  @JsonProperty("code")
  private Integer code;

  @JsonProperty("message")
  private String message;

  @JsonProperty("uri")
  private String uri;

  public ErrorResponse(HttpStatus status, Integer code, String message, String uri) {
    this.status = status;
    this.code = code;
    this.message = message;
    this.uri = uri;
  }
}