package com.example.Collections.sheets.and.sets;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

        public static final int maxPerson = 20;
        /*
        Создать сервис EmployeeService, который хранит внутри поле с коллекцией сотрудников и константу
        хранящее максимальное возможное количество сотрудников в фирме.
         */
        public static void main(String[] args) {

                List<Employee> employees = new ArrayList<>();
                employees.add(new Employee("John", " Michael"));
                employees.add(new Employee("Emma", " Olivia"));
                employees.add(new Employee("Michael", " James"));
                employees.add(new Employee("Olivia", " Grace"));
                employees.add(new Employee("James", " Alexander"));
                employees.add(new Employee("Ava", " Elizabeth"));
                employees.add(new Employee("William", " David"));
                employees.add(new Employee("Sophia", " Emily"));
                employees.add(new Employee("Benjamin", " Christopher"));
                employees.add(new Employee("Mia", " Charlotte"));

        }

        /*
        Реализовать в сервисе три метода, которые принимают в качестве параметров firstName и
        lastName:
        1. Добавить сотрудника.
        */

        /*
        Добавить в методы из шага 5 новые исключения.
        1. В метод с добавлением сотрудника нужно добавить выброс исключения из шага 7 в ситуации,
        когда коллекция переполнена.
        2. В метод с добавлением сотрудника нужно добавить выброс исключения из шага 8 в ситуации,
        когда добавляемый сотрудник уже имеется в коллекции.
        3. В метод с удалением сотрудника нужно добавить выброс исключения из шага 6 в ситуации,
        когда удаляемый сотрудник не найден.
        4. В метод с поиском сотрудника нужно добавить выброс исключения из шага 6 в ситуации,
        когда сотрудник не найден.
         */

        private static List<Employee> employees = new ArrayList<>();

        public Employee addEmployee(String firstName, String lastName) {
                if (employees.size() >= maxPerson) {
                        throw new EmployeeStorageIsFullException("Штат заполнен сотрудниками.");
                }
                Employee newEmployee = new Employee(firstName, lastName);
                if (employees.contains(newEmployee)) {
                        throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует.");
                }
                employees.add(newEmployee);
                return newEmployee;
        }

        //2. Удалить сотрудника.

        public Employee removeEmployee(String firstName, String lastName) {
                Employee employeeToRemove = findStaffer(firstName, lastName);
                employees.remove(employeeToRemove);
                return employeeToRemove;
        }

        //3. Найти сотрудника.

        public Employee findStaffer(String firstName, String lastName){
                return employees.stream()
                        .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                        .findFirst()
                        .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден: " + firstName + " " + lastName));
        }

        public List<Employee> getAllEmployees() {
                return new ArrayList<>(employees);
        }
}
