package com.example.Collections.sheets.and.sets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ErrorNumberException extends RuntimeException {
    public ErrorNumberException(String message){
        super(message);
    }
}
