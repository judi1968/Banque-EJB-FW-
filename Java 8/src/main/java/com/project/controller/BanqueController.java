package com.project.controller;

import com.project.service.BanqueClientService;
import metier.entities.Compte;
import metier.entities.VMouvementCourantNonValide;

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

    @GetMapping("/courants")
    public List<VMouvementCourantNonValide> getCourants() throws Exception {
        return service.getBanque().listMouvementCourantNonValide();
    }

    @PostMapping("/verser/{code}/{montant}")
    public void verser(@PathVariable Long code, @PathVariable double montant) {
        service.getBanque().verser(code, montant);
    }
}
