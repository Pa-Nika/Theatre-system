package ru.nsu.theatre.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.nsu.theatre.entities.Role;

import java.util.List;

public interface RoleRepository  extends CrudRepository<Role, Long> {
    Page<Role> findAll(Pageable pageable);

    @Query("SELECT r FROM Role r WHERE (:performance = 'Любой' OR r.performance.author.title = :performance)")
    List<Role> findByPerformance(@Param("performance") String performance);

    @Query("SELECT r FROM Role r WHERE (:performance = 'Любой' OR r.performance.author.title = :performance)")
    Page<Role> findByPerformance(@Param("performance") String performance, Pageable pageable);

    List<Role> findByPerformanceId(Long id);

}
