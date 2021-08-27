package com.avinash.covidproject.vaccination11.exceptions;

public class UserNotRegistered extends RuntimeException
{
    public UserNotRegistered(String message) {
        super(message);
    }

    public UserNotRegistered(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotRegistered(Throwable cause) {
        super(cause);
    }
}
