package ru.nsu.theatre.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.theatre.entities.Employee;
import ru.nsu.theatre.entities.EmployeeType;
import ru.nsu.theatre.entities.Gender;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
//    @Procedure(name = "get_employee_by_id")
//    ArrayList<Employee> getEmployeeById(Long id);

    @Query("SELECT e FROM Employee e WHERE (:gender = '' OR e.gender.type = :gender)")
    List<Employee> findByGender(@Param("gender") String gender);

}

