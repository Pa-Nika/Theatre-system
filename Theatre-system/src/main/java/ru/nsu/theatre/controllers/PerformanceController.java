package ru.nsu.theatre.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.theatre.entities.*;
import ru.nsu.theatre.repository.AuthorRepository;
import ru.nsu.theatre.repository.PerformanceRepository;
import ru.nsu.theatre.repository.RoleRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class PerformanceController {
    @Autowired
    private PerformanceRepository performanceRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/performance")
    public String getAllPerformances(Model model) {
        Iterable<Performance> performances = performanceRepository.findAll();

        model.addAttribute("performances", performances);
        return "performance";
    }

    @GetMapping("/see/performance")
    public String getAddPerformances(Model model) {
        Iterable<Performance> performances = performanceRepository.findAll();
        model.addAttribute("performance", performances);
        return "see/seePerformance";
    }

    @GetMapping("/add/performance")
    public String addAuthorGet(Model model) {

        List<Author> authors = new ArrayList<>();
        for (Author author : authorRepository.findAll()) {
            if (performanceRepository.findByAuthorId(author.getId()) == null) {
                authors.add(author);
            }
        }
        model.addAttribute("authors", authors);
        return "add/addPerformance";
    }

    @PostMapping("/add/performance")
    public String addAuthorPost(@RequestParam String title, @RequestParam Integer time,
                                @RequestParam Integer limit, @RequestParam LocalDate premiere, Model model) {
        Author author = authorRepository.findByTitle(title);
        Performance performance = new Performance(limit, premiere, author, time);
        performanceRepository.save(performance);
        return "redirect:/see/performance";
    }

    @GetMapping("/edit/performance/{id}")
    public String editPerformanceGet(@PathVariable(value = "id") long id, Model model) {
        if (!performanceRepository.existsById(id))
            return "see/seePerformance";

        Optional<Performance> performance = performanceRepository.findById(id);
        ArrayList<Performance> res = new ArrayList<>();
        performance.ifPresent(res::add);
        Author author = null;

        if (performance.isPresent()) {
            Performance p = performance.get();
            author = p.getAuthor();
        }

        List<Role> role = roleRepository.findByPerformanceId(id);

        model.addAttribute("performance", res);
        model.addAttribute("author", author);
        model.addAttribute("roles", role);

        return "edit/editPerformanceById";
    }


    @PostMapping("/edit/performance/{id}")
    public String editAuthorUpdate(@PathVariable(value = "id") long id, @RequestParam String title,
                                   @RequestParam Integer time, @RequestParam Integer limit,
                                   @RequestParam LocalDate premiere, Model model) {
        Performance performance = performanceRepository.findById(id).orElseThrow();
        performance.setLimit(limit);
        performance.setTime(time);
        performance.setPremiere(premiere);
        performanceRepository.save(performance);
        return "redirect:/see/performance";
    }

    @PostMapping("/remove/performance/{id}")
    public String editEmployeeUpdate(@PathVariable(value = "id") long id, Model model) {
        Performance performance = performanceRepository.findById(id).orElseThrow();
        performanceRepository.delete(performance);
        return "redirect:/see/performance";
    }
}