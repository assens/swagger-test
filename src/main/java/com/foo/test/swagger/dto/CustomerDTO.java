package com.foo.test.swagger.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel
public class CustomerDTO {
  private String name;
  private ZonedDateTime zonedDateTime;
  private LocalDateTime localDateTime;
  private Instant instant;
}
