package com.avinash.covidproject.vaccination11.exceptions;


import lombok.Data;

@Data
public class UserErrorResponse
{
    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    private String message1;
    private String message2;
    private long timeStamp;


    public UserErrorResponse(){

    }

    public UserErrorResponse(String message1, String message2, long timeStamp) {
        this.message1 = message1;
        this.message2 = message2;
        this.timeStamp = timeStamp;
    }
}