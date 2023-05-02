package ru.nsu.theatre.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.nsu.theatre.entities.Director;
import ru.nsu.theatre.entities.DirectorPerformance;
import ru.nsu.theatre.entities.HelpForNormForm.DirectorPerformanceId;
import ru.nsu.theatre.entities.Performance;

import java.util.List;

public interface DirectorPerformanceRepository extends CrudRepository<DirectorPerformance, DirectorPerformanceId> {

    @Query("SELECT dp.director FROM DirectorPerformance dp WHERE dp.performance = :performance")
    List<Director> findDirectorsByPerformance(@Param("performance") Performance performance);

}

