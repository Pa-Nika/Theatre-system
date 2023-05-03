package ru.nsu.theatre.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.theatre.entities.Performance;

@Repository
public interface PerformanceRepository extends CrudRepository<Performance, Long> {

    Page<Performance> findAll(Pageable pageable);
    Performance findByAuthorId(Long id);
    Performance findByPerformance(String performance);
}
