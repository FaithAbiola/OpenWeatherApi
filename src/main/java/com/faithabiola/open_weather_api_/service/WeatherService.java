package com.faithabiola.open_weather_api_.service;


import com.faithabiola.open_weather_api_.model.WeatherResponse;

public interface WeatherService {
    WeatherResponse getWeather(String city);
}
