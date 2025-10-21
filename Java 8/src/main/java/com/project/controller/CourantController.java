package com.project.controller;

import com.project.dto.CourantDTO;
import com.project.services.CourantService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourantController {

    @Autowired
    public CourantService courantService;

    @PostMapping("/courant")
    public String traiterCourant(@ModelAttribute CourantDTO courantDTO, HttpSession session) {
        try {
            if (courantDTO.getPersonneId() == null || courantDTO.getAction() == null || 
                courantDTO.getMontant() == null || courantDTO.getMontant() <= 0 ||
                courantDTO.getDateHeureAction() == null) {
                throw new Exception("Veuillez remplir tous les champs correctement.");
            }

            String actionMsg;
            String dateStr = courantDTO.getDateHeureAction().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            if (courantDTO.getAction() == 1) {
                actionMsg = "Dépôt de " + courantDTO.getMontant() + " effectué pour la personne ID " 
                            + courantDTO.getPersonneId() + " le " + dateStr;
            } else {
                actionMsg = "Retrait de " + courantDTO.getMontant() + " effectué pour la personne ID " 
                            + courantDTO.getPersonneId() + " le " + dateStr;
            }

            courantService.addMouvement(courantDTO);

            session.setAttribute("courantReussi", actionMsg);
            session.removeAttribute("courantErreur");
        } catch (Exception e) {
            session.setAttribute("courantErreur", e.getMessage());
            session.removeAttribute("courantReussi");
        }

        return "redirect:/insertion"; // page du formulaire
    }

    @GetMapping("/valider-mouvement")
    public String traiterValidationMouvement(@RequestParam("id") int idMouvement, HttpSession session) throws Exception{
        try {
            

            courantService.validerMouvement(idMouvement);

            session.setAttribute("courantValideReussi", "Validation du mouvement compte courant reussi");
            session.removeAttribute("courantValideErreur");
        } catch (Exception e) {
            session.setAttribute("courantValideErreur", e.getMessage());
            session.removeAttribute("courantValideReussi");
        }

        return "redirect:/insertion";
    }

}
