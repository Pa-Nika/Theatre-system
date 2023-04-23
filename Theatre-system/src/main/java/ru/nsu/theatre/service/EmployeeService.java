package ru.nsu.theatre.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.theatre.entities.Employee;
import ru.nsu.theatre.repository.EmployeeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}