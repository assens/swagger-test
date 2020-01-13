package com.foo.test.swagger.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel
public class ErrorDTO {
  private int code;
  private String message;
}
