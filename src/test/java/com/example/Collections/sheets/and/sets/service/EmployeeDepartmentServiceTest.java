package com.example.Collections.sheets.and.sets.service;

import com.example.Collections.sheets.and.sets.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class EmployeeDepartmentServiceTest {

    @InjectMocks
    private EmployeeDepartmentService employeeDepartmentService;

    @Mock
    private EmployeeService employeeService;

    private Employee[] mockEmployees;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        mockEmployees = new Employee[]{
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

        when(employeeService.getAllEmployees(Mockito.<Employee[]>any(), anyString()))
                .thenReturn(Arrays.asList(mockEmployees).toString());
    }

    @Test
    public void testGetEmployeesByDepartment() {
        List<Employee> employees = employeeDepartmentService.getEmployeesByDepartment("2");
        assertEquals(2, employees.size());

        assertTrue(employees.stream().allMatch(emp -> emp.getDepartment().equals("2")));
    }

    @Test
    public void testGetEmployeesByDepartmentShould() {
        List<Employee> employees = employeeDepartmentService.getEmployeesByDepartment("10");
        assertTrue(employees.isEmpty());
    }

    @Test
    public void testGetTotalSalaryByDepartment() {
        int totalSalary = employeeDepartmentService.getTotalSalaryByDepartment("2");
        assertEquals(99_000 + 83_000, totalSalary);
    }

    @Test
    public void testGetTotalSalaryByDepartmentNotFound() {
        int totalSalary = employeeDepartmentService.getTotalSalaryByDepartment("10");
        assertEquals(0, totalSalary);
    }

    @Test
    public void testGetMaxSalaryEmployee() {
        Employee employee = employeeDepartmentService.getMaxSalaryEmployee("3");
        assertNotNull(employee);
        assertEquals("Sophia", employee.getFirstName());
        assertEquals(150_000, employee.getSalary());
    }

    @Test
    public void testGetMaxSalaryEmployeeNotFound() {
        Employee employee = employeeDepartmentService.getMaxSalaryEmployee("10");
        assertNull(employee);
    }

    @Test
    public void testGetMinsalaryEmployee() {
        Employee employee = employeeDepartmentService.getMinSalaryEmployee("4");
        assertNotNull(employee);
        assertEquals("Ava", employee.getFirstName());
        assertEquals(75_000, employee.getSalary());
    }

    @Test
    public void testGetMinSalaryEmployeeNotFound() {
        Employee employee = employeeDepartmentService.getMinSalaryEmployee("10");
        assertNull(employee);
    }

    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = employeeDepartmentService.getAllEmployees();
        assertEquals(10, employees.size());
    }

}
