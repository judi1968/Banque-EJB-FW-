package com.project.service;

import com.project.entity.Personnes;
import com.project.model.ComptePersonne;
import com.project.model.MontantPersonneDTO;
import com.project.model.Personne;
import com.project.services.CourantService;
import com.project.services.PersonneService;

import metier.entities.VMontantPersonne;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComptePersonneService {

    @Autowired
    PersonneService personneServices;

    @Autowired 
    CourantService courantService;

    @Autowired
    MontantPersonneService montantPersonneService;

    public List<ComptePersonne> getAllComptes() throws Exception{
        List<VMontantPersonne> vMontantPersonnes = courantService.getAllMontantPersonnes(); 
        List<MontantPersonneDTO> montantPersonneDepot = montantPersonneService.getAllMontants(1);
        List<MontantPersonneDTO> montantPersonnePret = montantPersonneService.getAllMontants(2);

        List<Personnes> personnes = personneServices.getAll();
        List<ComptePersonne> comptes = new ArrayList<>();
        for (Personnes personne : personnes) {
            double montantCourant = courantService.getMontantPersonneActuelle(personne, vMontantPersonnes);
            double montantDepot = montantPersonneService.getMontantByPersonne(personne, montantPersonneDepot);
            double montantPret = montantPersonneService.getMontantByPersonne(personne, montantPersonnePret);
            double montantTotal = montantCourant + montantDepot + montantPret;
            comptes.add(new ComptePersonne(personne, montantCourant, montantDepot, montantPret));
        }
        
        return comptes;
    }
}
