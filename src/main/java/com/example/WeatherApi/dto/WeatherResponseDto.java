package com.example.WeatherApi.dto;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherResponseDto {

    @NotNull(message = "Latitude must not be null")
    @DecimalMin(value = "-90.0", message = "Latitude must be >= -90")
    @DecimalMax(value = "90.0", message = "Latitude must be <= 90")
    private Double latitude;

    @NotNull(message = "Longitude must not be null")
    @DecimalMin(value = "-180.0", message = "Longitude must be >= -180")
    @DecimalMax(value = "180.0", message = "Longitude must be <= 180")
    private Double longitude;

    @NotNull(message = "Temperature must not be null")
    private Double temperatureCelsius;

    @NotNull(message = "Wind speed must not be null")
    @PositiveOrZero(message = "Wind speed must be zero or positive")
    private Double windKmh;

    @NotNull(message = "Humidity must not be null")
    @DecimalMin(value = "0", message = "Humidity must be >= 0")
    @DecimalMax(value = "100", message = "Humidity must be <= 100")
    private Integer humidity;
}
