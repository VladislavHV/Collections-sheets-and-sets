package com.example.Collections.sheets.and.sets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
Реализовать EmployeeController, который имеет поле EmployeeService.
Объявить конструктор с этим параметром, чтобы заинджектить EmployeeService в EmployeeController.
 */


//Объявить в контроллере 3 метода:

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public void EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    private static List<Employee> employees = new ArrayList<>();

    public static final int maxPerson = 20;

    /*
    1. По адресу /employee/add?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате
    JSON, т.е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение ArrayIsFull в случае
    переполнения коллекции или EmployeeAlreadyAdded в случае, когда сотрудник уже существует.
     */
    @GetMapping(path = "/employee/add")
    public Employee addEmployee(String firstName, String lastName) {
        try {
            return employeeService.addEmployee(firstName, lastName);
        } catch (EmployeeStorageIsFullException | EmployeeAlreadyAddedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    /*
    2. По адресу /employee/remove?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в
    формате JSON, т.е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение со статусом
    EmployeeNotFound, если сотрудник отсутствует.
     */

    @GetMapping(path = "/employee/remove")
    public Employee removeEmployee(String firstName, String lastName) {
        try {
            return employeeService.removeEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    /*
    3. По адресу /employee/find?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в
    формате JSON, т.е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение со статусом
    EmployeeNotFound, если такой сотрудник отсутствует.
     */

    @GetMapping(path = "/employee/find")
    public Employee findStaffer(String firstName, String lastName) {
        try {
            return employeeService.findStaffer(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    /*
    Написать метод, который выводит в браузер список всех сотрудников в формате JSON
    (необходимо вернуть объект списка).
     */

    @GetMapping(path = "/employee/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
