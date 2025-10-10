package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.services.PersonneService;
import com.project.entity.Personnes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class RooterController {

    @Autowired
    private PersonneService personneService;

    
    @GetMapping("/")
    public String home() {
        return "pages/resultat"; 
    }

    @GetMapping("/insertion")
     public String form(Model model) {
        List<Personnes> personnes = personneService.getAll();
        model.addAttribute("personnes", personnes);
        return "pages/insertion";
    }

}
