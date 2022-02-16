package ru.otus.weatherApp.service;

import org.springframework.stereotype.Service;
import ru.otus.weatherApp.model.Weather;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherAggrigationService implements WeatherService {

    private final List<WeatherService> weatherServices;

    public WeatherAggrigationService(List<WeatherService> weatherServices) {
        this.weatherServices = weatherServices;
    }

    @Override
    public List<Weather> gWeather() {
        List<Weather> weatherList = new ArrayList<>();
        weatherServices.forEach(ws -> weatherList.addAll(ws.gWeather()));
        return weatherList;
    }
}
