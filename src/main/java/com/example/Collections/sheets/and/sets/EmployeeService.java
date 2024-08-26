package com.example.Collections.sheets.and.sets;

import com.example.Collections.sheets.and.sets.Exception.ErrorNumberException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

        public String getAllEmployees(Employee[] employees, String departmentId) {
                return Arrays.stream(employees)
                        .filter(employee -> employee.getDepartment().equals(departmentId))
                        .map(Employee :: toString)
                        .collect(Collectors.joining(", ", "[", "]"));
        }

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

        public void employeeNameСheck123(String firstName, String lastName) {
                if (StringUtils.containsAny(firstName, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9') ||
                        StringUtils.containsAny(lastName, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9')) {
                        throw new ErrorNumberException("Имена сотрудников содержат цифры.");
                }
        }

        public void emloyeeNameCheck_(String firstName, String lastName) {
                if (StringUtils.containsAny(firstName, "!@#$%^&*") ||
                        StringUtils.containsAny(lastName, "!@#$%^&*")) {
                        throw new ErrorNumberException("Имена сотрудников имеют символы.");
                }
        }

        public void employeeFirstCapitalization(String firstName, String lastName) {
                if (!isFirstLetterUpperCase(firstName) || !isFirstLetterUpperCase(lastName)){
                        throw new IllegalArgumentException("Имя и фамилия должны начинатся с заглавной буквы.");
                }
        }

        private boolean isFirstLetterUpperCase(String name) {
                if (StringUtils.isEmpty(name)) {
                        return false;
                }
                char firstChar = name.charAt(0);
                return Character.isUpperCase(firstChar);
        }

}
