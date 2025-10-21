package com.project.controller;

import com.project.dto.LoginDTO;
import com.project.service.SessionBanqueService;

import jakarta.servlet.http.HttpSession;
import metier.entities.Utilisateur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private final SessionBanqueService sessionBanqueService;

    public LoginController(SessionBanqueService service) {
        this.sessionBanqueService = service;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        // Appel du service Spring qui fait le lookup du Stateful EJB
        boolean success = sessionBanqueService.login(loginDTO.getUsername(), loginDTO.getPassword());

        if (success) {
            // Stockage de l'utilisateur connecté dans la session HTTP
            session.setAttribute("user",(Utilisateur) sessionBanqueService.getCurrentUser());
            redirectAttributes.addFlashAttribute("message", "Connexion réussie !");
            return "redirect:/insertion";
        } else {
            redirectAttributes.addFlashAttribute("message", "Connexion échouée, identifiants invalides.");
            return "redirect:/";
        }

        // Redirection vers la page principale
    }

    @GetMapping("/logout")
    public String login(RedirectAttributes redirectAttributes) {
        // Appel du service Spring qui fait le lookup du Stateful EJB
        sessionBanqueService.logout();
        // Redirection vers la page principale
        return "redirect:/";
    }

}
