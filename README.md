# Weather Information Service

Backend-only Spring Boot application that provides weather information for a given city.

## API Endpoint

GET /api/weather?city=Dhaka

### Response

{
    "humidity": 27,
    "latitude": 23.7231,
    "longitude": 90.4086,
    "temperatureCelsius": 26.9,
    "windKmh": 9.0
}

## Tech Stack

- Spring Boot
- Lombok
- WeatherAPI
- Java 21

## Features

- One public GET API
- No database
- Secure API key handling
- Validation and exception handling
- Clean layered architecture

## How to Run

1. Create free API key at https://www.weatherapi.com/
2. Set environment variable:

Windows:
setx WEATHER_API_KEY "your_key"

Linux/Mac:
export WEATHER_API_KEY=your_key

3. Run the app:

mvn spring-boot:run

## Design

Controller → Service → API Client → WeatherAPI
