package com.example.WeatherApi.service;


import com.example.WeatherApi.dto.WeatherResponseDto;

public interface WeatherService {
    WeatherResponseDto getWeatherByCity(String city);
}
