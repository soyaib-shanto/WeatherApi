package com.example.WeatherApi.controller;

import com.example.WeatherApi.dto.WeatherResponseDto;
import com.example.WeatherApi.service.WeatherService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
@Validated
public class WeatherController {

    private final WeatherService service;

    @GetMapping
    public WeatherResponseDto getWeather(@RequestParam @NotBlank String city) {
        return service.getWeatherByCity(city);
    }
}