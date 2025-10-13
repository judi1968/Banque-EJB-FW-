package com.project.controller;

import com.project.model.MouvementDepot;
import com.project.model.Personne;
import com.project.service.MouvementDepotService;
import com.project.service.PersonneServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depot")
public class MouvementDepotController {
    @Autowired
    private MouvementDepotService mouvementDepotService;

    @GetMapping
    public List<MouvementDepot> getMouvementDepot() {
        return mouvementDepotService.getAllMouvements();
    }
}
