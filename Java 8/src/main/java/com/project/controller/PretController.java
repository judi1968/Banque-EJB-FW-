package com.project.controller;

import com.project.dto.PretDTO;
import com.project.service.MouvementPretService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PretController {

    @Autowired
    public MouvementPretService mouvementPretService;

    @PostMapping("/pret")
    public String traiterPret(@ModelAttribute PretDTO pretDTO, HttpSession session) {
        try {
            if (pretDTO.getPersonneId() == null || pretDTO.getAction() == null || 
                pretDTO.getMontant() == null || pretDTO.getMontant() <= 0 ||
                pretDTO.getDateHeureAction() == null) {
                throw new Exception("Veuillez remplir tous les champs correctement.");
            }

            String actionMsg;
            String dateStr = pretDTO.getDateHeureAction().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            if (pretDTO.getAction() == 1) {
                actionMsg = "Prêt de " + pretDTO.getMontant() + " effectué pour la personne ID " 
                            + pretDTO.getPersonneId() + " le " + dateStr;
            } else {
                actionMsg = "Remboursement de " + pretDTO.getMontant() + " effectué pour la personne ID " 
                            + pretDTO.getPersonneId() + " le " + dateStr;
            }

            mouvementPretService.addMouvement(pretDTO);

            session.setAttribute("pretReussi", actionMsg);
            session.removeAttribute("pretErreur");
        } catch (Exception e) {
            session.setAttribute("pretErreur", e.getMessage());
            session.removeAttribute("pretReussi");
        }

        return "redirect:/insertion"; // page du formulaire
    }

}
