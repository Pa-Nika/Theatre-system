package ru.nsu.theatre.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.nsu.theatre.entities.Performance;
import ru.nsu.theatre.repository.PerformanceRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class PerformanceController {
    @Autowired
    private PerformanceRepository performanceRepository;

    @GetMapping("/performance")
    public String getAllPerformances(Model model) {
        Iterable<Performance> performances = performanceRepository.findAll();

        model.addAttribute("performances", performances);
        return "performance";
    }

//    @PostMapping("/employees")
//    public String findEmployee(@RequestParam String type, @RequestParam String gender, Model model) {
//        Iterable<Employee> employees = employeeRepository.findByGender(1);
//        Iterable<EmployeeType> employeeTypes = employeeTypeRepository.findAll();
//        Iterable<Gender> genders = genderRepository.findAll();
//        model.addAttribute("employees", employees);
//        model.addAttribute("employeeTypes", employeeTypes);
//        model.addAttribute("genders", genders);
//        return "/employees";
//    }
}