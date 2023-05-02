package ru.nsu.theatre.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

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


    @GetMapping("/see/employee")
    public String getAllGenres(Model model) {
        Iterable<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "see/seeEmployees";
    }

    @GetMapping("/edit/employee/{id}")
    public String editEmployee(@PathVariable(value = "id") long id, Model model) {
        if (!employeeRepository.existsById(id))
            return "see/seeEmployees";

//        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("get_employee_by_id", Employee.class);
//        storedProcedure.registerStoredProcedureParameter("employee_id", Integer.class, ParameterMode.IN);
//        storedProcedure.setParameter("employee_id", id);
//        List<Employee> employee = storedProcedure.getResultList();

        Optional<Employee> employee = employeeRepository.findById(id);
        ArrayList<Employee> res = new ArrayList<>();
        employee.ifPresent(res::add);
        Iterable<EmployeeType> employeeTypes = employeeTypeRepository.findAll();
        Iterable<Gender> genders = genderRepository.findAll();

        model.addAttribute("employee", res);
        model.addAttribute("employeeTypes", employeeTypes);
        model.addAttribute("genders", genders);
        return "edit/editEmployeeById";
    }

    @PostMapping("/edit/employee/{id}")
    public String editGenreUpdate(@PathVariable(value = "id") long id, @RequestParam String name,
                                  @RequestParam String type, @RequestParam String gender, @RequestParam LocalDate birthday,
                                  @RequestParam LocalDate work, @RequestParam Integer salary,
                                  @RequestParam Integer children, Model model) {
        EmployeeType employeeType = employeeTypeRepository.findByType(type);
        Gender gender1 = genderRepository.findByType(gender);

        Employee employee = employeeRepository.findById(id).orElseThrow();
        if (!Objects.equals(type, employee.getType().getType())) {
            employeeRepository.delete(employee);
            Employee myEmployee = new Employee(employeeType, birthday, name, work, salary, children, gender1);
            employeeRepository.save(myEmployee);
            return "redirect:/see/employee";
        }

        employee.setDateOfBirth(birthday);
        employee.setName(name);
        employee.setChildren(children);
        employee.setGender(gender1);
        employee.setSalary(salary);
        employee.setWork(work);
        employeeRepository.save(employee);
        return "redirect:/see/employee";
    }

    @PostMapping("/remove/employee/{id}")
    public String editEmployeeUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(employee);
        return "redirect:/see/employee";
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