package com.gohar.customer.customer.handler;

import com.gohar.customer.customer.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handle(CustomerNotFoundException customerNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customerNotFoundException.getMsg());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException methodArgumentNotValidException){
        var errors = new HashMap<String,String>();
        methodArgumentNotValidException.getBindingResult().getAllErrors()
                .forEach(error ->{
                  var filedName = ((FieldError)error).getField();
                  var errorMassage = error.getDefaultMessage();
                  errors.put(filedName,errorMassage);
                });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }
}
