package ru.nsu.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.nsu.theatre.entities.Gender;

public interface GenderRepository extends CrudRepository<Gender, Long> {
    Gender findByType(String type);
}
