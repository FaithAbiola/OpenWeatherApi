package com.faithabiola.open_weather_api_.service.impl;

import com.faithabiola.open_weather_api_.exception.CityNotFoundException;
import com.faithabiola.open_weather_api_.model.WeatherResponse;
import com.faithabiola.open_weather_api_.service.WeatherService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String OPEN_WEATHER_API_KEY = "4483cb9c50246e6a8e290c06c46fea50";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public WeatherResponse getWeather(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" +
                OPEN_WEATHER_API_KEY;
// Create the header
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity entity = new HttpEntity<>(httpHeaders);

        WeatherResponse response;
        //pass the parameters
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    WeatherResponse.class
            ).getBody();
        if(response.getCod().equals(404))
            throw new CityNotFoundException("City not found", 404);
        return response;
    }
}
