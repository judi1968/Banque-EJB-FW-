package com.project.service;

import com.project.configuration.PretApiProperties;
import com.project.model.Personne;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonneServices {

    private final RestTemplate restTemplate;
    private final PretApiProperties pretApiProperties;

    public PersonneServices(RestTemplate restTemplate, PretApiProperties pretApiProperties) {
        this.restTemplate = restTemplate;
        this.pretApiProperties = pretApiProperties;
    }

    // 🔹 Lire toutes les personnes
    public List<Personne> getAllPersonnes() {
        String url = pretApiProperties.getUrl() + "/api/personne";
        ResponseEntity<List<Personne>> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Personne>>() {}
        );

        return response.getBody();
    }

    // 🔹 Ajouter une personne
    public Personne addPersonne(Personne personne) {
            String url = pretApiProperties.getUrl() + "/api/personne";

            // On encapsule dans un objet { "personne": { ... } }
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("Nom", personne.getNom());
            requestBody.put("Prenom", personne.getPrenom());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
            String dateUtc = personne.getDateNaissance().atStartOfDay(ZoneOffset.UTC).format(formatter);
            requestBody.put("DateNaissance", dateUtc);

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody);

            return restTemplate.postForObject(url, request, Personne.class);

    }
}
