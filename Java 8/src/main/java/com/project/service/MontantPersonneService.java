package com.project.service;

import com.project.configuration.DepotApiProperties;
import com.project.configuration.PretApiProperties;
import com.project.entity.Personnes;
import com.project.model.MontantPersonneDTO;
import com.project.model.Personne;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MontantPersonneService {

    private final RestTemplate restTemplate;
    private final DepotApiProperties depotApiProperties;
    private final PretApiProperties pretApiProperties;

    public MontantPersonneService(RestTemplate restTemplate, DepotApiProperties depotApiProperties, PretApiProperties pretApiProperties) {
        this.restTemplate = restTemplate;
        this.depotApiProperties = depotApiProperties;
        this.pretApiProperties = pretApiProperties;
    }

    public List<MontantPersonneDTO> getAllMontants(int type) { // 1 : depot , 2 : pret
        String url = depotApiProperties.getUrl() + "/api/montant_personne";
        if (type == 2) {
            url = pretApiProperties.getUrl() + "/api/montant_personne"; // à créer côté .NET si nécessaire
        }
        ResponseEntity<List<MontantPersonneDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MontantPersonneDTO>>() {}
        );
        return response.getBody();
    }

    public double getMontantByPersonne(Personnes personne, List<MontantPersonneDTO> montantPersonneDTOs){
        for (MontantPersonneDTO montantPersonneDTO : montantPersonneDTOs) {
            if (personne.getId() == montantPersonneDTO.getIdPersonne()) {
                return montantPersonneDTO.getMontantActuelle();
            }
        }
        return 0;
    }

    // public MontantPersonneDTO getMontantById(int idPersonne) {
    //     String url = depotApiProperties.getUrl() + "/api/montant_personne/" + idPersonne;
    //     return restTemplate.getForObject(url, MontantPersonneDTO.class);
    // }
}
