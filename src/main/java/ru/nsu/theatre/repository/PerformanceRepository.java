package ru.nsu.theatre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.theatre.entities.Author;
import ru.nsu.theatre.entities.Performance;

@Repository
public interface PerformanceRepository extends CrudRepository<Performance, Long> {

//    Author findAuthorIdById(Long id);
    Performance findByAuthorId(Long id);
    Performance findByPerformance(String performance);
}
