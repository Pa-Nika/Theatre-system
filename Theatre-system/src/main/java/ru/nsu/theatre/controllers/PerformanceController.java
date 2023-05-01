package ru.nsu.theatre.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.nsu.theatre.entities.Performance;
import ru.nsu.theatre.repository.PerformanceRepository;

@Controller
@AllArgsConstructor
public class PerformanceController {
    @Autowired
    private PerformanceRepository performanceRepository;

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

}