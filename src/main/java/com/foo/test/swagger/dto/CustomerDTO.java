package com.foo.test.swagger.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel
public class CustomerDTO {
  private String name;

  @ApiModelProperty
  private ZonedDateTime zonedDateTime;

  @ApiModelProperty
  private OffsetDateTime offsetDateTime;

  @ApiModelProperty
  private LocalDateTime localDateTime;

  @ApiModelProperty
  private Instant instant;

  @ApiModelProperty
  private LocalDate localDate;

  @ApiModelProperty(dataType = "java.time.OffsetDateTime")
  private LocalTime localTime;
}
