package ru.nsu.theatre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.theatre.entities.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
