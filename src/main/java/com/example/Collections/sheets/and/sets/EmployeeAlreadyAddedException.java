package com.example.Collections.sheets.and.sets;

/*
Написать собственное непроверяемое исключение EmployeeAlreadyAddedException, которое выбрасывается,
когда нового сотрудника пытаются добавить в коллекцию, а в коллекции уже есть такой сотрудник.
 */

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String message){
        super(message);
    }
}
