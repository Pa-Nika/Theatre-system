package ru.nsu.theatre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.theatre.entities.Gender;
import ru.nsu.theatre.repository.GenderRepository;

@RestController
public class GenderController {
    @Autowired
    private GenderRepository genderRepository;

    public Iterable<Gender> getAllTypes() {
        return genderRepository.findAll();
    }
}
