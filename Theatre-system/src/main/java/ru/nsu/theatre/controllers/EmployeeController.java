package ru.nsu.theatre.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.theatre.entities.Employee;
import ru.nsu.theatre.entities.EmployeeType;
import ru.nsu.theatre.entities.Gender;
import ru.nsu.theatre.repository.EmployeeRepository;
import ru.nsu.theatre.repository.EmployeeTypeRepository;
import ru.nsu.theatre.repository.GenderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@AllArgsConstructor
public class EmployeeController {
    @PersistenceContext
    private EntityManager entityManager;

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
        return "employees";
    }


    @GetMapping("/add/employee")
    public String getAllGenres(Model model) {
        Iterable<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "add/addEmployees";
    }

//    @GetMapping("/edit/employee/{id}")
//    public String editEmployee(@PathVariable(value = "id") long id, Model model) {
//        if (!employeeRepository.existsById(id))
//            return "add/addEmployees";
//        Optional<Employee> employee = employeeRepository.findById(id);
//        ArrayList<Employee> res = new ArrayList<>();
//        employee.ifPresent(res::add);
//        model.addAttribute("employee", res);
//        return "edit/editEmployeeById";
//    }


    @PostMapping("/remove/employee/{id}")
    public String editEmployeeUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(employee);
        return "redirect:/add/employee";
    }


    @PostMapping("/employees")
    public String  findEmployee(@RequestParam String type, @RequestParam String gender, Model model) {
        Iterable<Employee> employees = employeeRepository.findByGender(gender);
//        employees = employeeRepository.findByType(type, employees);

        Iterable<EmployeeType> employeeTypes = employeeTypeRepository.findAll();
        Iterable<Gender> genders = genderRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("employeeTypes", employeeTypes);
        model.addAttribute("genders", genders);
        return "/employees";
    }
}