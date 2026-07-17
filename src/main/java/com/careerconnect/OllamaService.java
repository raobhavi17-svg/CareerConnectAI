package com.careerconnect;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class OllamaService {

    private final WebClient webClient;

    public OllamaService() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:11434")
                .build();
    }

    public String askOllama(String prompt) {

        Map<String, Object> request = Map.of(
                "model", "llama3.2:latest",
                "prompt", prompt,
                "stream", false
        );

        Map response = webClient.post()
                .uri("/api/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        return response.get("response").toString();
    }
}