package com.project.service;

import com.project.model.Personne;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
public class PersonneService {

    private final RestTemplate restTemplate;

    public PersonneService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Personne> getAllPersonnes() {
        String url = "http://localhost:5056/api/personne"; // ton API .NET

        ResponseEntity<List<Personne>> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Personne>>() {}
        );

        return response.getBody();
    }
}
