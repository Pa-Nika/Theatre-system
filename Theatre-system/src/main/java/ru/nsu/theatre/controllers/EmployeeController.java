package ru.nsu.theatre.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.nsu.theatre.entities.Employee;
import ru.nsu.theatre.entities.EmployeeType;
import ru.nsu.theatre.entities.Gender;
import ru.nsu.theatre.entities.Genre;
import ru.nsu.theatre.repository.EmployeeRepository;
import ru.nsu.theatre.repository.EmployeeTypeRepository;
import ru.nsu.theatre.repository.GenderRepository;
import ru.nsu.theatre.repository.GenreRepository;

@Controller
//@RequestMapping("")
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;


    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        Iterable<Employee> employees = employeeRepository.findAll();
        Iterable<EmployeeType> employeeTypes = employeeTypeRepository.findAll();
        Iterable<Gender> genders = genderRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("employeeTypes", employeeTypes);
        model.addAttribute("genders", genders);
        return "employee";
    }
}