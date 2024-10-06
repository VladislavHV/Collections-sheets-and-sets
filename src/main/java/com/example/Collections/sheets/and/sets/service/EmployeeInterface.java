package com.example.Collections.sheets.and.sets.service;

import com.example.Collections.sheets.and.sets.model.Employee;

public interface EmployeeInterface {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findStaffer(String firstName, String lastName);

    Employee employeeNameСheck123(String firstName, String lastName);

    Employee emloyeeNameCheck_(String firstName, String lastName);

    Employee employeeFirstCapitalization(String firstName, String lastName);
}
