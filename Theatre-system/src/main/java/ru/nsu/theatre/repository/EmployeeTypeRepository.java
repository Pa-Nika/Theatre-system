package ru.nsu.theatre.repository;

import org.springframework.data.repository.CrudRepository;
import ru.nsu.theatre.entities.EmployeeType;

public interface EmployeeTypeRepository extends CrudRepository<EmployeeType, Long> {
}
