package com.example.Collections.sheets.and.sets;

/*
Написать собственное непроверяемое исключение EmployeeStorageIsFullException, которое выбрасывается,
если превышен лимит количества сотрудников в фирме.
 */

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message){
        super(message);
    }
}
