package com.project.controller;

import com.project.model.Personne;
import com.project.service.PersonneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneService service;

    public PersonneController(PersonneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Personne> getPersonnes() {
        return service.getAllPersonnes();
    }

    @PostMapping
    public Personne addPersonne(@RequestBody Personne personne) {
        return service.addPersonne(personne);
    }
}
