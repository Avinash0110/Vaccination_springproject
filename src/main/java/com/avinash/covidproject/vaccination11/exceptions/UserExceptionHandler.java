package com.avinash.covidproject.vaccination11.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exc)
    {
        UserErrorResponse error = new UserErrorResponse();

        error.setMessage1("user not found");
        error.setMessage2(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(Exception exc)
    {
        UserErrorResponse error = new UserErrorResponse();

        error.setMessage1("user not found ");
        error.setMessage2(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public String registerHandler(UserNotRegistered userNotRegistered)
    {

        return "error/user-not-registered";
    }
}