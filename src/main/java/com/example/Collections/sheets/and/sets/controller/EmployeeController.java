package com.example.Collections.sheets.and.sets.controller;

import com.example.Collections.sheets.and.sets.model.Employee;
import com.example.Collections.sheets.and.sets.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class EmployeeController{

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam String departmentId) {
        Employee[] employees = getEmployees();

        for (Employee employee : employees){
            employeeService.employeeNameСheck123(employee.getFirstName(), employee.getLastName());
            employeeService.emloyeeNameCheck_(employee.getFirstName(), employee.getLastName());
            employeeService.employeeFirstCapitalization(employee.getFirstName(), employee.getLastName());
        }
        return employeeService.maximumWage(getEmployees(), departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam String departmentId) {
        Employee[] employees = getEmployees();

        for (Employee employee : employees) {
            employeeService.employeeNameСheck123(employee.getFirstName(), employee.getLastName());
            employeeService.emloyeeNameCheck_(employee.getFirstName(), employee.getLastName());
            employeeService.employeeFirstCapitalization(employee.getFirstName(), employee.getLastName());
        }
        return employeeService.minimumWage(getEmployees(), departmentId);
    }

    @GetMapping(path = "/all")
    public Object getEmployees(@RequestParam(required = false) String departmentId) {
        Employee[] employees = getEmployees();

        for (Employee employee : employees){
            employeeService.employeeNameСheck123(employee.getFirstName(), employee.getLastName());
            employeeService.emloyeeNameCheck_(employee.getFirstName(), employee.getLastName());
            employeeService.employeeFirstCapitalization(employee.getFirstName(), employee.getLastName());
        }
        if (departmentId == null) {
            return employeeService.getAllEmployeeDepartment(getEmployees(), departmentId);
        } else {
            return employeeService.getAllEmployees(getEmployees(), departmentId);
        }
    }

    private Employee[] getEmployees() {
        return new Employee[]{
                new Employee("John", "Michael", 70_000, "5"),
                new Employee("Emma", "Olivia", 105_000, "3"),
                new Employee("Michael", "James", 80_000, "4"),
                new Employee("Olivia", "Grace", 83_000, "2"),
                new Employee("James", "Alexander", 99_000, "2"),
                new Employee("Ava", "Elizabeth", 75_000, "4"),
                new Employee("William", "David", 88_000, "5"),
                new Employee("Sophia", "Emily", 150_000, "3"),
                new Employee("Benjamin", "Christopher", 115_000, "1"),
                new Employee("Mia", "Charlotte", 92_000, "1"),
        };
    }
}
