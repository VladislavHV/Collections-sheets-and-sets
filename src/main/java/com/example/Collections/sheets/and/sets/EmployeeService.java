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

        //Переработать все методы по работе с хранилищем на работу с методами Map.

        /*
        public EmployeeService() {
                addEmployee("John", " Michael");
                addEmployee("Emma", " Olivia");
                addEmployee("Michael", " James");
                addEmployee("Olivia", " Grace");
                addEmployee("James", " Alexander");
                addEmployee("Ava", " Elizabeth");
                addEmployee("William", " David");
                addEmployee("Sophia", " Emily");
                addEmployee("Benjamin", " Christopher");
                addEmployee("Mia", " Charlotte");
        }
        */

        //public static final int maxPerson = 20;
        /*
        Создать сервис EmployeeService, который хранит внутри поле с коллекцией сотрудников и константу
        хранящее максимальное возможное количество сотрудников в фирме.
         */
        /*
        public static void main(String[] args) {

                Map<String, Employee> employees = new HashMap<>();
        }
        */
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

        /*
        Продумать контракт для ключей, чтобы сотрудник с одним ФИО существовал только
        в одном экземпляре, корректно добавлялся и удалялся.
         */

        //private Map<String, Employee> employees;

        /*
        public EmployeeService() {
            this.employees = new HashMap<>();
        }
        */

        /*
        private String generateKey(String firstName, String lastName) {
                return firstName + " " + lastName;
        }
         */

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


        /*
        public Employee printPerson(Employee[] employees, String departmentId){
                return Arrays.stream(employees)
                        .filter(employee -> employee.getDepartment().equals(departmentId))
                        .forEach(employee -> System.out.println(employee.getFullName() + " " + employee.getSalary()));
        }
         */
}
