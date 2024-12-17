package com.example.top_trumps_the_bible.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class BibleApiService {

    @Value("${bible.api.key}")
    private String apiKey;

    @Value("${bible.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    // Constructor injection for RestTemplate
    public BibleApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getPassage(String bibleId, String passageId) {
        System.out.println("Fetching passage with Bible ID: " + bibleId + " and Passage ID: " + passageId);
        String url = "https://api.scripture.api.bible/v1/bibles/" + bibleId + "/passages/" + passageId;

        // Synchronously call the API and return the passage
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(createHeaders()),  // Adds headers with API key
                String.class
            );
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return "Unable to retrieve passage.";
        }
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", apiKey);  // Ensure apiKey is initialized correctly
        return headers;
    }
}
