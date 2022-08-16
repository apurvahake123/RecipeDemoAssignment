package com.example.Recipe.Recipedemo.exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @Autowired
    Environment environment;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Errorinfo> exceptionHandler(Exception exception)
    {
        Errorinfo error = new Errorinfo();
        error.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<Errorinfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(RecipedemoException.class)
    public ResponseEntity<Errorinfo> recipeDemoExceptionHandler(RecipedemoException exception)
    {
        Errorinfo error = new Errorinfo();
        error.setErrorMessage(environment.getProperty(exception.getMessage()));
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<Errorinfo>(error, HttpStatus.NOT_FOUND);
    }
}

