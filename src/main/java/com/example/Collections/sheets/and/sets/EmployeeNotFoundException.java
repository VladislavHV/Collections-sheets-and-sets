package com.example.Collections.sheets.and.sets;

/*
Написать собственное непроверяемое исключение EmployeeNotFoundException, которое выбрасывается,
если сотрудник не найден.
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException (String message){
        super(message);
    }
}
