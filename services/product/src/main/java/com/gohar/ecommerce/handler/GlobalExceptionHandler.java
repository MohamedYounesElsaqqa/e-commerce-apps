package com.gohar.ecommerce.handler;

import com.gohar.ecommerce.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductPurchaseException.class)
    public ResponseEntity<String> handle(ProductPurchaseException productPurchaseException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productPurchaseException.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handle(EntityNotFoundException entityNotFoundException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(entityNotFoundException.getMessage());
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
