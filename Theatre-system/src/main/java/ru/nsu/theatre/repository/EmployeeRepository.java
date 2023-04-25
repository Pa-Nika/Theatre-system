package ru.nsu.theatre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.theatre.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
