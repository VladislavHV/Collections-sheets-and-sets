package com.example.Collections.sheets.and.sets;

public interface EmployeeInterface {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findStaffer(String firstName, String lastName);
}
