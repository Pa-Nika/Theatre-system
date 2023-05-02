package ru.nsu.theatre.repository;

import org.springframework.data.repository.CrudRepository;
import ru.nsu.theatre.entities.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
    Country findByCountry(String country);
}
