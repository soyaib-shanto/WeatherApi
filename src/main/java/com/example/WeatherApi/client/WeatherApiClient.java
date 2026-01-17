package com.example.WeatherApi.client;

import com.example.WeatherApi.config.WeatherApiConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class WeatherApiClient {

    private final WeatherApiConfig config;

    public String getWeather(String city) {
        WebClient webClient = WebClient.builder()
                .baseUrl(config.getBaseUrl())
                .defaultHeader("User-Agent", "Spring Boot WeatherApp")
                .build();

        try {
            String response = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("key", config.getApiKey())
                            .queryParam("q", city)
                            .build())
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            System.out.println("RAW API RESPONSE: " + response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to call Weather API: " + e.getMessage());
        }
    }
}
