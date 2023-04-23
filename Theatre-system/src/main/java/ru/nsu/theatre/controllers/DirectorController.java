package ru.nsu.theatre.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.theatre.entities.Director;
import ru.nsu.theatre.service.DirectorService;

import java.util.List;

@RestController
@AllArgsConstructor
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