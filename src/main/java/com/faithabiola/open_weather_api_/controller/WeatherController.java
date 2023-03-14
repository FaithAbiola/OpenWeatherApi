package com.faithabiola.open_weather_api_.controller;


import com.faithabiola.open_weather_api_.model.WeatherResponse;
import com.faithabiola.open_weather_api_.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @CrossOrigin(origins = "http://localhost:3001")
    @GetMapping(value = "/city/{city}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<WeatherResponse> getWeather(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getWeather(city));
    }
}
