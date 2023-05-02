package ru.nsu.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.theatre.entities.Director;

import java.util.List;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Integer> {
//    List<Director> findAll();
}
