package ru.nsu.theatre.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.nsu.theatre.entities.Director;
import ru.nsu.theatre.repository.DirectorRepository;

import javax.transaction.Transactional;
import java.util.List;

public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    @Transactional
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }
}
