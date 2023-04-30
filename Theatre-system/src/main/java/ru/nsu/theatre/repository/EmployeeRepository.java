package ru.nsu.theatre.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.theatre.entities.Employee;
import ru.nsu.theatre.entities.EmployeeType;
import ru.nsu.theatre.entities.Gender;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
//    List<Employee> findByGender(Long gender);

//    List<Employee> findByTypeAndGender(EmployeeType type, Gender gender);

    @Query("SELECT e FROM Employee e WHERE (:gender = '' OR e.gender.type = :gender)")
    List<Employee> findByGender(@Param("gender") String gender);

//    @Query("SELECT e FROM Employee e WHERE (:gender = '' OR e.gender.type = :gender)")
//    List<Employee> findByType(@Param("type") String type, @Param("employees") Iterable<Employee> emp);


//    List<Employee> findByUsername(String username);
}

