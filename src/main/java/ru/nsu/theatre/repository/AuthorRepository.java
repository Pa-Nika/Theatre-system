package ru.nsu.theatre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.theatre.entities.Author;
import ru.nsu.theatre.entities.Genre;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByTitle(String title);

}
