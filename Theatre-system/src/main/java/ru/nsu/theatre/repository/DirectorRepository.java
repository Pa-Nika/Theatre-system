package ru.nsu.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.theatre.entities.Director;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
    List<Director> findAll();
}
