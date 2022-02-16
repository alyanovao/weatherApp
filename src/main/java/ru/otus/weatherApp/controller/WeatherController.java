package ru.otus.weatherApp.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.weatherApp.model.Weather;
import ru.otus.weatherApp.service.WeatherService;

import java.util.List;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(@Qualifier("weatherAggrigationService") WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("api/weather")
    public List<Weather> getWeather() {return weatherService.gWeather();}
}
