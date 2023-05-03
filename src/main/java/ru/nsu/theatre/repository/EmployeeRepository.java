package ru.nsu.theatre.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.theatre.entities.Employee;
import ru.nsu.theatre.entities.Gender;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

//    List<Employee> findByGender(Gender gender);

    @Query("SELECT e FROM Employee e WHERE (:gender = '' OR e.gender.type = :gender)")
    Page<Employee> findByGender(@Param("gender") String gender, Pageable pageable);

    Page<Employee> findAll(Pageable pageable);
}

