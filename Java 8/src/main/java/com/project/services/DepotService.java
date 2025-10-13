package com.project.services;

import com.project.dto.CourantDTO;
import com.project.dto.DepotDTO;
import com.project.entity.Personnes;
import com.project.repository.PersonneRepository;
import com.project.service.BanqueClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepotService {
    @Autowired
    private BanqueClientService banqueClientService;
    
    public void addMouvement(DepotDTO dto) throws Exception{
        double montantEnter = 0;
        double montantSortie = 0;
        if (dto.getAction() == 1) {
            montantEnter = dto.getMontant();
        }else{
            montantSortie = dto.getMontant();
        }
        banqueClientService.getBanque().addMouvementCourant(dto.getPersonneId(), montantEnter, montantSortie, dto.getDateHeureAction());
    }
}
