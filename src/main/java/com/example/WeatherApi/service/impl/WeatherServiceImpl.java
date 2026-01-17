package com.example.WeatherApi.service.impl;

import com.example.WeatherApi.client.WeatherApiClient;
import com.example.WeatherApi.dto.WeatherResponseDto;
import com.example.WeatherApi.service.WeatherService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherApiClient client;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public WeatherResponseDto getWeatherByCity(String city) {
        try {
            String response = client.getWeather(city);

            // 👇 Debug (remove later)
            System.out.println("RAW API RESPONSE: " + response);

            JsonNode root = mapper.readTree(response);

            // ✅ Handle WeatherAPI errors properly
            if (root.has("error")) {
                String message = root.get("error").get("message").asText();
                throw new RuntimeException("Weather API error: " + message);
            }

            JsonNode location = root.get("location");
            JsonNode current = root.get("current");

            if (location == null || current == null) {
                throw new RuntimeException("Invalid response structure from Weather API");
            }

            return WeatherResponseDto.builder()
                    .latitude(location.get("lat").asDouble())
                    .longitude(location.get("lon").asDouble())
                    .temperatureCelsius(current.get("temp_c").asDouble())
                    .windKmh(current.get("wind_kph").asDouble())
                    .humidity(current.get("humidity").asInt())
                    .build();

        } catch (Exception e) {
            e.printStackTrace(); // 👈 shows real error in console
            throw new RuntimeException("Failed to process weather data: " + e.getMessage());
        }
    }
}
