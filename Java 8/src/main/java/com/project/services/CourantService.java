package com.project.services;

import com.project.dto.CourantDTO;
import com.project.entity.Personnes;
import com.project.model.Personne;
import com.project.repository.PersonneRepository;
import com.project.service.BanqueClientService;

import metier.entities.VMontantPersonne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourantService {
    @Autowired
    private BanqueClientService banqueClientService;
    public void addMouvement(CourantDTO dto) throws Exception{
        double montantEnter = 0;
        double montantSortie = 0;
        if (dto.getAction() == 1) {
            montantEnter = dto.getMontant();
        }else{
            montantSortie = dto.getMontant();
        }
        banqueClientService.getBanque().addMouvementCourant(dto.getPersonneId(), montantEnter, montantSortie, dto.getDateHeureAction());
    }

    public List<VMontantPersonne> getAllMontantPersonnes() throws Exception{
        return banqueClientService.getBanque().findAllMontantActuelle();
    }

    public double getMontantPersonneActuelle(Personnes personne, List<VMontantPersonne> montantPersonnes) throws Exception{
        for (VMontantPersonne vMontantPersonne : montantPersonnes) {
            if (personne.getId() == vMontantPersonne.getIdPersonne()) {
                return vMontantPersonne.getMontant();
            }
        }
        return 0;
    }
}
