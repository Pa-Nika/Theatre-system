package ru.nsu.theatre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nsu.theatre.entities.*;
import ru.nsu.theatre.repository.AuthorRepository;
import ru.nsu.theatre.repository.CountryRepository;
import ru.nsu.theatre.repository.GenreRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Controller
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/see/author")
    public String getAllAuthorsSee(Model model) {
        Iterable<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "see/seeAuthors";
    }

    @GetMapping("/edit/author/{id}")
    public String editAuthor(@PathVariable(value = "id") long id, Model model) {
        if (!authorRepository.existsById(id))
            return "see/seeAuthors";

        Optional<Author> author = authorRepository.findById(id);
        ArrayList<Author> res = new ArrayList<>();
        author.ifPresent(res::add);
        Iterable<Country> country = countryRepository.findAll();
        Iterable<Genre> genres = genreRepository.findAll();

        model.addAttribute("author", res);
        model.addAttribute("country", country);
        model.addAttribute("genre", genres);
        return "edit/editAuthorById";
    }

    @PostMapping("/edit/author/{id}")
    public String editAuthorUpdate(@PathVariable(value = "id") long id, @RequestParam String name,
                                  @RequestParam String country, @RequestParam String title,
                                  @RequestParam String genre, @RequestParam LocalDate birthday, Model model) {
        Country country1 = countryRepository.findByCountry(country);
        Genre genre1 = genreRepository.findByGenreClass(genre);

        Author author = authorRepository.findById(id).orElseThrow();
        author.setDateOfBirth(birthday);
        author.setName(name);
        author.setCountry(country1);
        author.setTitle(title);
        author.setGenre(genre1);
        authorRepository.save(author);
        return "redirect:/see/author";
    }

    @GetMapping("/add/author")
    public String addAuthorGet(Model model) {
        Iterable<Country> country = countryRepository.findAll();
        Iterable<Genre> genre = genreRepository.findAll();
        model.addAttribute("country", country);
        model.addAttribute("genre", genre);
        return "add/addAuthor";
    }

    @PostMapping("/add/author")
    public String addAuthorPost( @RequestParam String name, @RequestParam String country, @RequestParam String title,
                           @RequestParam String genre, @RequestParam LocalDate birthday, Model model) {
        Country country1 = countryRepository.findByCountry(country);
        Genre genre1 = genreRepository.findByGenreClass(genre);
        Author author = new Author(country1, birthday, name, genre1, title);
        authorRepository.save(author);
        return "redirect:/see/author";
    }

    @PostMapping("/remove/author/{id}")
    public String editEmployeeUpdate(@PathVariable(value = "id") long id, Model model) {
        Author author = authorRepository.findById(id).orElseThrow();
        authorRepository.delete(author);
        return "redirect:/see/author";
    }
}