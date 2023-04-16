package ru.nsu.theatre.controllers;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.theatre.entities.Client;
import ru.nsu.theatre.service.ClientService;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }


    @GetMapping("/hello")
    public String getHello() {
        return "Hello!";
    }

}
