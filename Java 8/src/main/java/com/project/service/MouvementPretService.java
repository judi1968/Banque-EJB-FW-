package com.project.service;

import com.project.configuration.PretApiProperties;
import com.project.dto.PretDTO;
import com.project.model.MouvementPret;
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
public class MouvementPretService {

    private final RestTemplate restTemplate;
    private final PretApiProperties pretApiProperties;

    public MouvementPretService(RestTemplate restTemplate, PretApiProperties pretApiProperties) {
        this.restTemplate = restTemplate;
        this.pretApiProperties = pretApiProperties;
    }

    // 🔹 Lire tous les mouvements de prêt
    public List<MouvementPret> getAllMouvements() {
        String url = pretApiProperties.getUrl() + "/api/mouvement_pret";
        ResponseEntity<List<MouvementPret>> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<MouvementPret>>() {}
        );
        return response.getBody();
    }

    // 🔹 Ajouter un mouvement
    public MouvementPret addMouvement(MouvementPret mouvement) {
        String url = pretApiProperties.getUrl() + "/api/mouvement_pret";

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("idPersonne", mouvement.getIdPersonne());
        requestBody.put("montantEntrer", mouvement.getMontantEntrer());
        requestBody.put("montantSortie", mouvement.getMontantSortie());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        requestBody.put("dateMouvement", mouvement.getDateMouvement().format(formatter));

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody);

        return restTemplate.postForObject(url, request, MouvementPret.class);
    }

    public MouvementPret addMouvement(PretDTO pretDTO) {
        String url = pretApiProperties.getUrl() + "/api/mouvement_pret";

        MouvementPret mouvementPret = new MouvementPret();
        mouvementPret.setDateMouvement(pretDTO.getDateHeureAction());
        mouvementPret.setIdPersonne(pretDTO.getPersonneId());
        mouvementPret.setIdMouvement(pretDTO.getAction());
        mouvementPret.setMontantEntrer(0);
        mouvementPret.setMontantSortie(0);

        if (pretDTO.getAction() == 2) 
            mouvementPret.setMontantEntrer(pretDTO.getMontant());
        else 
            mouvementPret.setMontantSortie(pretDTO.getMontant());

        // Construction du corps JSON à envoyer
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("idPersonne", mouvementPret.getIdPersonne());
        requestBody.put("montantEntrer", mouvementPret.getMontantEntrer());
        requestBody.put("montantSortie", mouvementPret.getMontantSortie());

        // Format de la date : "yyyy-MM-dd'T'HH:mm:ss"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String dateStr = mouvementPret.getDateMouvement().format(formatter);
        requestBody.put("dateMouvement", dateStr);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody);

        return restTemplate.postForObject(url, request, MouvementPret.class);
    }

}
