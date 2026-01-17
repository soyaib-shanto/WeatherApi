package com.example.WeatherApi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "weatherapi")
public class WeatherApiConfig {
    private String baseUrl;
    private String apiKey;
}
