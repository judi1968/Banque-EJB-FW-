package com.project.services;

import com.project.entity.Personnes;
import com.project.repository.PersonneRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonneService {

    private final PersonneRepository repository;

    public PersonneService(PersonneRepository repository) {
        this.repository = repository;
    }

    public List<Personnes> getAll() {
        return repository.findAll();
    }

    public Personnes getById(int id) {
        return repository.findById(id).orElse(null);
    }
}
