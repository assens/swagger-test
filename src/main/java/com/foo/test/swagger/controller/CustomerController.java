package com.foo.test.swagger.controller;

import static org.springframework.http.HttpStatus.CONFLICT;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.foo.test.swagger.dto.CustomerDTO;
import com.foo.test.swagger.dto.ErrorDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customer")
@Api(tags = "Customer")
public class CustomerController {

  @GetMapping
  @ApiOperation("getCustomer")
  @ApiResponses({
    @ApiResponse(code = 200, response = CustomerDTO.class, message = "Customer"),
  })
  public CustomerDTO getCustomer() {
    return CustomerDTO.builder().name("Баба меца").build();
  }

  @GetMapping("/error")
  @ApiOperation("getError")
  @ApiResponses({
    @ApiResponse(code = 200, response = CustomerDTO.class, message = "No Error"),
    @ApiResponse(code = 409, response = ErrorDTO.class, message = "Error")
  })
  public CustomerDTO getError() {
    throw new IllegalArgumentException("Грешка");
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(code = CONFLICT)
  public ErrorDTO handleIllegalArgumentException(final IllegalArgumentException e) {
    return ErrorDTO.builder().code(CONFLICT.value()).message(e.getMessage()).build();
  }
}
