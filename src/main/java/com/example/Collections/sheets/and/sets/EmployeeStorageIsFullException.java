package com.example.Collections.sheets.and.sets;

/*
Написать собственное непроверяемое исключение EmployeeStorageIsFullException, которое выбрасывается,
если превышен лимит количества сотрудников в фирме.
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message){
        super(message);
    }
}
