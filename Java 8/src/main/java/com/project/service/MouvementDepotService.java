package com.project.service;

import com.project.configuration.DepotApiProperties;
import com.project.configuration.PretApiProperties;
import com.project.dto.DepotDTO;
import com.project.model.MouvementDepot;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MouvementDepotService {

    private final RestTemplate restTemplate;
    private final DepotApiProperties depotApiProperties;

    public MouvementDepotService(RestTemplate restTemplate, DepotApiProperties depotApiProperties) {
        this.restTemplate = restTemplate;
        this.depotApiProperties = depotApiProperties;
    }

    // 🔹 Lire tous les mouvements de dépôt
    public List<MouvementDepot> getAllMouvements() {
        String url = depotApiProperties.getUrl() + "/api/mouvement_depot";
        ResponseEntity<List<MouvementDepot>> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<MouvementDepot>>() {}
        );

        return response.getBody();
    }

    // 🔹 Ajouter un mouvement de dépôt
    public MouvementDepot addMouvement(MouvementDepot mouvementDepot) {
        String url = depotApiProperties.getUrl() + "/api/mouvement_depot";

        // Construction du corps JSON à envoyer
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("idPersonne", mouvementDepot.getIdPersonne());
        requestBody.put("montantEntrer", mouvementDepot.getMontantEntrer());
        requestBody.put("montantSortie", mouvementDepot.getMontantSortie());

        // Format de la date : "yyyy-MM-dd'T'HH:mm:ss"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String dateStr = mouvementDepot.getDateMouvement().format(formatter);
        requestBody.put("dateMouvement", dateStr);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody);

        return restTemplate.postForObject(url, request, MouvementDepot.class);
    }

    public MouvementDepot addMouvement(DepotDTO depotDTO) {
        String url = depotApiProperties.getUrl() + "/api/mouvement_depot";

        MouvementDepot mouvementDepot = new MouvementDepot();
        mouvementDepot.setDateMouvement(depotDTO.getDateHeureAction());
        mouvementDepot.setIdPersonne(depotDTO.getPersonneId());
        mouvementDepot.setIdMouvement(depotDTO.getAction());
        mouvementDepot.setMontantEntrer(0);
        mouvementDepot.setMontantSortie(0);
        if (depotDTO.getAction() == 1) mouvementDepot.setMontantEntrer(depotDTO.getMontant());
        else mouvementDepot.setMontantSortie(depotDTO.getMontant());
        // Construction du corps JSON à envoyer
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("idPersonne", mouvementDepot.getIdPersonne());
        requestBody.put("montantEntrer", mouvementDepot.getMontantEntrer());
        requestBody.put("montantSortie", mouvementDepot.getMontantSortie());

        // Format de la date : "yyyy-MM-dd'T'HH:mm:ss"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String dateStr = mouvementDepot.getDateMouvement().format(formatter);
        requestBody.put("dateMouvement", dateStr);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody);

        return restTemplate.postForObject(url, request, MouvementDepot.class);
    }
}
