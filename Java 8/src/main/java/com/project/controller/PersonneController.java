package com.project.controller;

import com.project.model.Personne;
import com.project.service.PersonneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonneController {

    private final PersonneService service;

    public PersonneController(PersonneService service) {
        this.service = service;
    }

    @GetMapping("/personnes")
    public List<Personne> getPersonnes() {
        return service.getAllPersonnes();
    }
}
