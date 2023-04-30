package ru.nsu.theatre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.theatre.entities.Author;
import ru.nsu.theatre.repository.AuthorRepository;

@RestController
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    public Iterable<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}