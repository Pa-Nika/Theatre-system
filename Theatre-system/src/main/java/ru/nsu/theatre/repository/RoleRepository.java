package ru.nsu.theatre.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.nsu.theatre.entities.Role;

import java.util.List;

public interface RoleRepository  extends CrudRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE (:performance = 'Любой' OR r.performance.author.title = :performance)")
    List<Role> findByPerformance(@Param("performance") String performance);

    List<Role> findByPerformanceId(Long id);

}
