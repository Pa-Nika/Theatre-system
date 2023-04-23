package ru.nsu.theatre.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.theatre.entities.Employee;
import ru.nsu.theatre.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    @GetMapping("/hello")
    public String getHello() {
        return "Hello!";
    }

}