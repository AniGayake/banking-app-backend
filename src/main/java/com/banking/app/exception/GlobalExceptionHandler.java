package com.banking.app.exception;

import com.banking.app.exception.customexceptions.DuplicateUserException;
import com.banking.app.exception.customexceptions.InvalidCredentialsException;
import com.banking.app.exception.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = InvalidCredentialsException.class)
    public ResponseEntity<ErrorMessage> badCredentials(InvalidCredentialsException authException){
        ErrorMessage errorMessage= new ErrorMessage(
          authException.getType(),
                authException.getHttpStatus(),
                authException.getDetail()
        );
        return new ResponseEntity<>(errorMessage,HttpStatus.valueOf(authException.getHttpStatus()));
    }
    @ExceptionHandler(value = DuplicateUserException.class)
    public ResponseEntity<ErrorMessage> duplicateUserException(DuplicateUserException exception){
        ErrorMessage errorMessage = new ErrorMessage(exception.getErrorMessage().getType(), exception.getErrorMessage().getHttpStatusCode(),exception.getErrorMessage().getDetail());
        return new ResponseEntity<>(errorMessage,HttpStatus.valueOf(exception.getErrorMessage().getHttpStatusCode()));

    }
}
