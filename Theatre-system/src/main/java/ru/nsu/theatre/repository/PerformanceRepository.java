package ru.nsu.theatre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.theatre.entities.Performance;

@Repository
public interface PerformanceRepository extends CrudRepository<Performance, Long> {
}
