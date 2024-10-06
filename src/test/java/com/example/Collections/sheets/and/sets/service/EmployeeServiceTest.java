package com.example.Collections.sheets.and.sets.service;

import com.example.Collections.sheets.and.sets.exception.ErrorNumberException;
import com.example.Collections.sheets.and.sets.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService;
    private Employee[] employees;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService();
        employees = new Employee[]{
                new Employee("John", "Doe", 50000, "1"),
                new Employee("Frank", "Smith", 60000, "2"),
                new Employee("Mike", "Johnson", 55000, "1"),
                new Employee("Emily", "Brown", 45000, "2")
        };
    }

    @Test
    public void testGetAllEmployees_ShouldReturn() {
        String departmentId = "1";
        String expected = "[Employee{department='1', firstName='John', lastName='Doe', salary=50000}, " +
                "Employee{department='1', firstName='Mike', lastName='Johnson', salary=55000}]";
        assertEquals(expected, employeeService.getAllEmployees(employees, departmentId));
    }

    @Test
    public void testMinimumWage_ShouldReturn() {
        String departmentId = "1";
        Employee expected = new Employee("John", "Doe", 50000, "1");
        assertEquals(expected, employeeService.minimumWage(employees, departmentId));
    }

    @Test
    public void testMaximumWage_ShouldReturn() {
        String departmentId = "2";
        Employee expected = new Employee("Frank", "Smith", 60000, "2");
        assertEquals(expected, employeeService.maximumWage(employees, departmentId));
    }

    @Test
    public void testGetAllEmployeeDepartment() {
        Map<String, List<Employee>> result = employeeService.getAllEmployeeDepartment(employees, null);
        assertEquals(2, result.size());
        assertEquals(2, result.get("1").size());
        assertEquals(2, result.get("2").size());
    }

    @Test
    public void testEmployeeNameCheck() {
        assertThrows(ErrorNumberException.class, () -> {
            employeeService.employeeNameСheck123("John", "1Doe");
        });
    }

    @Test
    public void testEmployeeNameCheckSymbols() {
        assertThrows(ErrorNumberException.class, () -> {
            employeeService.emloyeeNameCheck_("John!", "Doe");
        });
    }

    @Test
    public void testEmployeeFirstCapitalization() {
        assertThrows(IllegalArgumentException.class, () -> {
            employeeService.employeeFirstCapitalization("John", "doe");
        });
    }

}
