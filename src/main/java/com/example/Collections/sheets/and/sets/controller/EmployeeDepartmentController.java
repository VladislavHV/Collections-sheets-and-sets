package com.example.Collections.sheets.and.sets.controller;

import com.example.Collections.sheets.and.sets.model.Employee;
import com.example.Collections.sheets.and.sets.service.EmployeeDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class EmployeeDepartmentController {

    private final EmployeeDepartmentService employeeDepartmentService;

    @Autowired
    public EmployeeDepartmentController(EmployeeDepartmentService employeeDepartmentService) {
        this.employeeDepartmentService = employeeDepartmentService;
    }

    @GetMapping(path="/{id}/employees")
    public List<Employee> getEmployeeByDepartment(@PathVariable String id) {
        return employeeDepartmentService.getEmployeesByDepartment(id);
    }

    @GetMapping(path="/{id}/salary/sum")
    public int getTotalSalaryDepartment(@PathVariable String id) {
        return employeeDepartmentService.getTotalSalaryByDepartment(id);
    }

    @GetMapping(path="/{id}/salary/max")
    public Employee getSalaryMaxDepartment(@PathVariable String id) {
        return employeeDepartmentService.getMaxSalaryEmployee(id);
    }

    @GetMapping(path="/{id}/salary/min")
    public Employee getSalaryMinDepartment(@PathVariable String id) {
        return employeeDepartmentService.getMinSalaryEmployee(id);
    }

    @GetMapping(path="/employees")
    public List<Employee> getAllEmployee() {
        return employeeDepartmentService.getAllEmployees();
    }

}
