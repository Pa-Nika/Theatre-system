package ru.nsu.theatre.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.theatre.entities.*;
import ru.nsu.theatre.entities.HelpForNormForm.DirectorPerformanceId;
import ru.nsu.theatre.repository.*;

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
    private DirectorPerformanceRepository directorPerformanceRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/performance")
    public String getAllPerformances(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int size,
                                     Model model) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        Page<Performance> performances = performanceRepository.findAll(pageable);

        model.addAttribute("currentPage", page);
        model.addAttribute("performances", performances);
        return "performance";
    }

    @GetMapping("/see/performance")
    public String getSeePerformances(Model model) {
        Iterable<Performance> performances = performanceRepository.findAll();
        model.addAttribute("performance", performances);
        return "see/seePerformance";
    }

    @GetMapping("/add/performance")
    public String addPerformanceGet(Model model) {

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
    public String addPerformancePost(@RequestParam String title, @RequestParam Integer time,
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
        List<Director> directors = directorPerformanceRepository.findDirectorsByPerformance(res.get(0));

        model.addAttribute("performance", res);
        model.addAttribute("author", author);
        model.addAttribute("roles", role);
        model.addAttribute("directors", directors);

        return "edit/editPerformanceById";
    }

    @PostMapping("/remove/director/performance/{id}/{id_p}")
    public String removeDirectorPerformance(@PathVariable(value = "id") long id,
                                            @PathVariable(value = "id_p") long idPerformance, Model model) {

        DirectorPerformanceId dpId = new DirectorPerformanceId();
        dpId.setDirectorId(id);
        dpId.setPerformanceId(idPerformance);

        Optional<DirectorPerformance> directorPerformance = directorPerformanceRepository.findById(dpId);
        ArrayList<DirectorPerformance> res = new ArrayList<>();
        directorPerformance.ifPresent(res::add);

        directorPerformanceRepository.delete(res.get(0));
        return "redirect:/edit/performance/{id_p}";
    }

    @PostMapping("/edit/performance/{id}")
    public String editPerformance(@PathVariable(value = "id") long id, @RequestParam String title,
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
    public String removePerformance(@PathVariable(value = "id") long id, Model model) {
        Performance performance = performanceRepository.findById(id).orElseThrow();
        performanceRepository.delete(performance);
        return "redirect:/see/performance";
    }
}