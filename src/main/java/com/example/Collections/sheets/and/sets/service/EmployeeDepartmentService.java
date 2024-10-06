package com.example.Collections.sheets.and.sets.service;

import com.example.Collections.sheets.and.sets.model.Employee;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeDepartmentService {

    private final Employee[] employees = {
            new Employee("John", "Michael", 70_000, "5"),
            new Employee("Emma", "Olivia", 105_000, "3"),
            new Employee("Michael", "James", 80_000, "4"),
            new Employee("Olivia", "Grace", 83_000, "2"),
            new Employee("James", "Alexander", 99_000, "2"),
            new Employee("Ava", "Elizabeth", 75_000, "4"),
            new Employee("William", "David", 88_000, "5"),
            new Employee("Sophia", "Emily", 150_000, "3"),
            new Employee("Benjamin", "Christopher", 115_000, "1"),
            new Employee("Mia", "Charlotte", 92_000, "1")
    };

    public List<String> getAllDepartments() {
        return Arrays.stream(employees)
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesByDepartment(String departmentId) {
        return Arrays.stream(employees)
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .collect(Collectors.toList());
    }

    public int getTotalSalaryByDepartment(String departmentId) {
        return Arrays.stream(employees)
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public Employee getMaxSalaryEmployee(String departmentId) {
        return Arrays.stream(employees)
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getMinSalaryEmployee(String departmentId) {
        return Arrays.stream(employees)
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return Arrays.stream(employees).collect(Collectors.toList());
    }

}
