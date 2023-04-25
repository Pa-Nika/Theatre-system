package ru.nsu.theatre.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.nsu.theatre.entities.Employee;
import ru.nsu.theatre.entities.EmployeeType;
import ru.nsu.theatre.entities.Genre;
import ru.nsu.theatre.repository.EmployeeRepository;
import ru.nsu.theatre.repository.EmployeeTypeRepository;
import ru.nsu.theatre.repository.GenreRepository;

@Controller
//@RequestMapping("")
@AllArgsConstructor
public class EmployeeController {
//    @Autowired
//    private EmployeeRepository employeeRepository;

    @Autowired
    private GenreRepository genreRepository;

//    @Autowired
//    private EmployeeTypeRepository employeeTypeRepository;


    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        Iterable<Genre> employees = genreRepository.findAll();
//        Iterable<EmployeeType> employeeTypes = employeeTypeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employee";
    }
}