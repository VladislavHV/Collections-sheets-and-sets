package com.example.Collections.sheets.and.sets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
Реализовать EmployeeController, который имеет поле EmployeeService.
Объявить конструктор с этим параметром, чтобы заинджектить EmployeeService в EmployeeController.
 */


//Объявить в контроллере 3 метода:

@RestController
@RequestMapping("/employee")
public class EmployeeController implements EmployeeInterface{

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
    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(required = true) String firstName,
                                @RequestParam(required = true) String lastName) {
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

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(required = true) String firstName,
                                   @RequestParam(required = true) String lastName) {
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

    @GetMapping(path = "/find")
    public Employee findStaffer(@RequestParam(required = true) String firstName,
                                @RequestParam(required = true) String lastName) {
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

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
