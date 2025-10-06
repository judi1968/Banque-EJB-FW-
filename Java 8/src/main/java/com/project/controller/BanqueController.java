package com.project.controller;

import com.project.service.BanqueClientService;
import metier.entities.Compte;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banque")
public class BanqueController {

    private final BanqueClientService service;

    public BanqueController(BanqueClientService service) {
        this.service = service;
    }

    @GetMapping("/comptes")
    public List<Compte> getComptes() {
        return service.getBanque().listComptes();
    }

    @PostMapping("/verser/{code}/{montant}")
    public void verser(@PathVariable Long code, @PathVariable double montant) {
        service.getBanque().verser(code, montant);
    }
}
