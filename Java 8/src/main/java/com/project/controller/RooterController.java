package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.services.CourantService;
import com.project.services.PersonneService;
import com.project.entity.Personnes;
import metier.entities.VMouvementCourantNonValide;
import com.project.service.ComptePersonneService;

import org.springframework.ui.Model;
import java.util.List;

@Controller
public class RooterController {

    @Autowired
    private PersonneService personneService;

    @Autowired
    private ComptePersonneService comptePersonneService;

    @Autowired
    private CourantService courantService;
    
    @GetMapping("/resultat")
    public String home(Model model) throws Exception{
        model.addAttribute("comptes", comptePersonneService.getAllComptes());
        return "pages/resultat"; 
    }

    @GetMapping("/insertion")
     public String form(Model model) throws Exception {
        List<Personnes> personnes = personneService.getAll();
        List<VMouvementCourantNonValide> vMouvementCourantNonValides =  courantService.getCourantsNonValide(); 
        model.addAttribute("personnes", personnes);
        model.addAttribute("vMouvementCourantNonValides", vMouvementCourantNonValides);

        return "pages/insertion";
    }

    @GetMapping("/")
    public String login(Model model) throws Exception{
        model.addAttribute("comptes", comptePersonneService.getAllComptes());
        return "pages/login"; 
    }
    

}
