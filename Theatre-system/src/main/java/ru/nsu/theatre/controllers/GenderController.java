package ru.nsu.theatre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.theatre.entities.Employee;
import ru.nsu.theatre.entities.Gender;
import ru.nsu.theatre.repository.EmployeeRepository;
import ru.nsu.theatre.repository.GenderRepository;

import java.util.List;

@RestController
public class GenderController {
    @Autowired
    private GenderRepository genderRepository;

    public Iterable<Gender> getAllTypes() {
        return genderRepository.findAll();
    }



//    @PostMapping("/employees")
//    public List<Employee> findEmployee(@RequestParam String type, @RequestParam String gender, Model model) {
////        Long id = genderRepository.findIdByType(gender);
//        List<Employee> genders =  getUsersByUsername("Демчук Роман Евгеньевич");
//        return genders;
//    }
}
