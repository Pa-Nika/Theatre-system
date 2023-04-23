package ru.nsu.theatre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import ru.nsu.theatre.entities.Director;
import ru.nsu.theatre.service.DirectorService;

import java.util.List;

public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping("/directors")
    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }


    @GetMapping("/hello")
    public String getHello() {
        return "Hello!";
    }

}