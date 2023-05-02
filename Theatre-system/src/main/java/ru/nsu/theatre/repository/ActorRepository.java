package ru.nsu.theatre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.theatre.entities.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
}
