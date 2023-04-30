package ru.nsu.theatre.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.theatre.entities.Genre;
import ru.nsu.theatre.repository.GenreRepository;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/add/genre")
    public String getAllGenres(Model model) {
        Iterable<Genre> genres = genreRepository.findAll();
        model.addAttribute("genres", genres);
        return "add/addGenre";
    }

    @GetMapping("/edit/genre/{id}")
    public String edieGenre(@PathVariable(value = "id") long id, Model model) {
        if (!genreRepository.existsById(id))
            return "add/addGenre";
        Optional<Genre> genre = genreRepository.findById(id);
        ArrayList<Genre> res = new ArrayList<>();
        genre.ifPresent(res::add);
        model.addAttribute("genre", res);
        return "edit/editGenreById";
    }

    @PostMapping("/add/genre")
    public String addGenre(@RequestParam String genreClass, Model model) {
        if(Objects.equals(genreClass, "")) {
            return "redirect:/add/genre";
        }

        Iterable<Genre> genres = genreRepository.findAll();
        for(Genre it: genres) {
            if (Objects.equals(genreClass, it.getGenre_class()))
                return "redirect:/add/genre";
        }

        Genre genre = new Genre(genreClass);
        genreRepository.save(genre);
        return "redirect:/add/genre";
    }

    @PostMapping("/edit/genre/{id}")
    public String editGenreUpdate(@PathVariable(value = "id") long id, @RequestParam String genreClass, Model model) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        genre.setGenre_class(genreClass);
        genreRepository.save(genre);
        return "redirect:/add/genre";
    }

    @PostMapping("/remove/genre/{id}")
    public String removeGenre(@PathVariable(value = "id") long id, Model model) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        genreRepository.delete(genre);
        return "redirect:/add/genre";
    }
}

