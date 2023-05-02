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
import ru.nsu.theatre.repository.GenderRepository;
import ru.nsu.theatre.repository.PerformanceRepository;
import ru.nsu.theatre.repository.RoleRepository;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PerformanceRepository performanceRepository;

    @Autowired
    private GenderRepository genderRepository;

    @GetMapping("/role")
    public String getAllRoles(Model model) {
        String str = "Любой";
        Iterable<Role> role = roleRepository.findAll();
        Iterable<Performance> performances = performanceRepository.findAll();
        model.addAttribute("roles", role);
        model.addAttribute("performances", performances);
        model.addAttribute("namePerformance", str);
        return "role";
    }

    @PostMapping("/role")
    public String postAllRoles(@RequestParam String performance, Model model) {
        Iterable<Role> role = roleRepository.findByPerformance(performance);
        Iterable<Performance> performances = performanceRepository.findAll();
        model.addAttribute("roles", role);
        model.addAttribute("performances", performances);
        model.addAttribute("namePerformance", performance);
        return "role";
    }


    @GetMapping("/edit/role/{id}")
    public String editRoleGet(@PathVariable(value = "id") long id, Model model) {
        if (!roleRepository.existsById(id))
            return "see/seePerformance";

        Optional<Role> role = roleRepository.findById(id);
        ArrayList<Role> res = new ArrayList<>();
        role.ifPresent(res::add);
        Iterable<Gender> genders = genderRepository.findAll();

        model.addAttribute("role", res);
        model.addAttribute("genders", genders);
        return "edit/editRoleById";
    }

    @PostMapping("/edit/role/{id}")
    public String editRolePost(@PathVariable(value = "id") long id, @RequestParam String name,
                                  @RequestParam String gender, @RequestParam Integer height,
                                  @RequestParam Integer age, @RequestParam Boolean choice, Model model) {
        Gender gender1 = genderRepository.findByType(gender);
        Role role = roleRepository.findById(id).orElseThrow();
        Long perfId = role.getPerformance().getId();

        role.setAge(age);
        role.setName(name);
        role.setGender(gender1);
        role.setHeight(height);
        role.setMain(choice);
        roleRepository.save(role);
        return "redirect:/edit/performance/" + perfId;
    }

    @GetMapping("/add/role/{id}")
    public String addRoleGet(@PathVariable(value = "id") long id, Model model) {
        if (!performanceRepository.existsById(id))
            return "see/seePerformance";

        Optional<Performance> performance = performanceRepository.findById(id);
        ArrayList<Performance> res = new ArrayList<>();
        performance.ifPresent(res::add);
        Iterable<Gender> genders = genderRepository.findAll();

        model.addAttribute("performance", res);
        model.addAttribute("genders", genders);
        return "add/addRole";
    }

    @PostMapping("/add/role/{id}")
    public String addRolePost(@PathVariable(value = "id") long id, @RequestParam String name,
                               @RequestParam String gender, @RequestParam Integer height,
                               @RequestParam Integer age, @RequestParam Boolean choice, Model model) {
        Gender gender1 = genderRepository.findByType(gender);
        Optional<Performance> performance = performanceRepository.findById(id);
        ArrayList<Performance> res = new ArrayList<>();
        performance.ifPresent(res::add);

        Role role = new Role(name, choice, age, gender1, height, res.get(0));
        roleRepository.save(role);
        return "redirect:/edit/performance/{id}";
    }

    @PostMapping("/remove/role/{id}/{id_p}")
    public String removeRoleId(@PathVariable(value = "id") long id, @PathVariable(value = "id_p") long idPerformance,
                               Model model) {
        Role role = roleRepository.findById(id).orElseThrow();
        roleRepository.delete(role);

        return "redirect:/edit/performance/{id_p}";
    }
}
