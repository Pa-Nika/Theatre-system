package ru.nsu.theatre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.theatre.entities.Genre;
import ru.nsu.theatre.repository.GenreRepository;

@Controller
//@RequestMapping("")
//@AllArgsConstructor
public class MainController {
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

}
