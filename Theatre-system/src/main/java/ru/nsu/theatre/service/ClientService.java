package ru.nsu.theatre.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.theatre.entities.Client;
import ru.nsu.theatre.repository.ClientRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}