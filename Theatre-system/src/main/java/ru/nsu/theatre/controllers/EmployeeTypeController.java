package ru.nsu.theatre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.theatre.entities.EmployeeType;
import ru.nsu.theatre.repository.EmployeeTypeRepository;

import java.util.List;

@RestController
public class EmployeeTypeController {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    public Iterable<EmployeeType> getAllTypes() {
        return employeeTypeRepository.findAll();
    }
}
