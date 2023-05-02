package ru.nsu.theatre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.theatre.entities.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre findByGenreClass(String genre_class);
}
