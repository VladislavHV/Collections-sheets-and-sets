package com.example.Collections.sheets.and.sets;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/*
Перенести проект с EmployeeBook на Map в качестве хранилища сотрудников,
реализовав методы добавления, удаления и поиска.
 */
@Service
public class EmployeeService {


        /*
        Заменить реализацию через циклы на Stream API.
        Написать новый контроллер и сервис
         */

        public String getAllEmployees(Employee[] employees, String departmentId) {
                return Arrays.stream(employees)
                        .filter(employee -> employee.getDepartment().equals(departmentId))
                        .map(Employee :: toString)
                        .collect(Collectors.joining(", ", "[", "]"));
        }

        //В текущий проект на Spring перенести методы работы с отделами из курсовой работы.

        public Employee minimumWage(Employee[] employees, String departmentId) {
                return Arrays.stream(employees)
                        .filter(employee -> employee.getDepartment().equals(departmentId))
                        .min(Comparator.comparingInt(Employee :: getSalary))
                        .orElse(null);

        }

        public Employee maximumWage(Employee[] employees, String departmentId){
                return Arrays.stream(employees)
                        .filter(employee -> employee.getDepartment().equals(departmentId))
                        .max(Comparator.comparingInt(Employee :: getSalary))
                        .orElse(null);
        }

        public Map<String, List<Employee>> getAllEmployeeDepartment(Employee[] employees, String departmentId) {
                return Arrays.stream(employees)
                        .collect(Collectors.groupingBy(Employee::getDepartment));
        }
}
