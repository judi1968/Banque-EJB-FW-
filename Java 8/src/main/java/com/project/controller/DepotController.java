package com.project.controller;

import com.project.dto.DepotDTO;
import com.project.service.MouvementDepotService;
import com.project.services.DepotService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepotController {

    @Autowired
    public MouvementDepotService mouvementDepotService;

    @PostMapping("/depot")
    public String traiterDepot(@ModelAttribute DepotDTO depotDTO, HttpSession session) {
        try {
            if (depotDTO.getPersonneId() == null || depotDTO.getAction() == null || 
                depotDTO.getMontant() == null || depotDTO.getMontant() <= 0 ||
                depotDTO.getDateHeureAction() == null) {
                throw new Exception("Veuillez remplir tous les champs correctement.");
            }

            String actionMsg;
            String dateStr = depotDTO.getDateHeureAction().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            if (depotDTO.getAction() == 1) {
                actionMsg = "Dépôt de " + depotDTO.getMontant() + " effectué pour la personne ID " 
                            + depotDTO.getPersonneId() + " le " + dateStr;
            } else {
                actionMsg = "Retrait de " + depotDTO.getMontant() + " effectué pour la personne ID " 
                            + depotDTO.getPersonneId() + " le " + dateStr;
            }

            mouvementDepotService.addMouvement(depotDTO);

            session.setAttribute("depotReussi", actionMsg);
            session.removeAttribute("depotErreur");
        } catch (Exception e) {
            session.setAttribute("depotErreur", e.getMessage());
            session.removeAttribute("depotReussi");
        }

        return "redirect:/insertion"; // page du formulaire
    }

    

}
