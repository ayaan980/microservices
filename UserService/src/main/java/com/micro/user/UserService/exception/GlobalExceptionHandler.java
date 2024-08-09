package com.micro.user.UserService.exception;

import com.micro.user.UserService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex)
    {
        String message = ex.getMessage();
        ApiResponse status = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
      return new ResponseEntity<>(status,HttpStatus.NOT_FOUND);
    }
}
